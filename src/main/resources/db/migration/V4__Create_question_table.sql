create table question (
                          id int unsigned not null auto_increment,
                          title varchar(50) not null default '' comment '标题',
                          description text comment '描述',
                          creator int not null default 0 comment '创建人',
                          comment_count int not null default 0 comment '评论数',
                          view_count int not null default 0 comment '浏览数',
                          like_count int not null default 0 comment '点赞数',
                          tag varchar(256) not null default '' comment '点赞数',
                          gmt_create bigint not null default 0 comment '创建时间',
                          gmt_modified bigint not null default 0 comment '最后修改时间',
                          primary key (id)
) comment '帖子';