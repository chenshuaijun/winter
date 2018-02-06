
CREATE DATABASE IF NOT EXISTS winterdb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- 创建用户信息表
create table user_info(
    user_id varchar(32) not null,
    user_name varchar(32),
    mobile varchar(32),
    email varchar(64)
);

-- 用户密码信息表
create table user_passwd_info (
    user_id varchar(32) not null,
    password  varchar(64)
);


