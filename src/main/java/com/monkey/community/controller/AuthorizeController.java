package com.monkey.community.controller;

import com.monkey.community.dto.AccessTokenDTO;
import com.monkey.community.dto.GithubUser;
import com.monkey.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tao
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String secret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClientId(clientId);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClientSecret(secret);
        accessTokenDTO.setRedirectUri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null) {
            // 登录成功，写cookie 和 session
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        } else {
            // 登录失败，重新登陆
            return "redirect:/";
        }
    }
}
