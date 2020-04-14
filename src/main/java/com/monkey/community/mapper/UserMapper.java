package com.monkey.community.mapper;

import com.monkey.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tao
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(name, account_id, token, gmt_create, gmt_modified) values (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insert(User user);
}
