CREATE TABLE `user` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
                        `account_id` varchar(100) NOT NULL DEFAULT '' COMMENT '用户id',
                        `token` char(36) NOT NULL DEFAULT '' COMMENT '用户token',
                        `bio` varchar(256) NOT NULL DEFAULT '',
                        `gmt_create` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
                        `gmt_modified` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user';