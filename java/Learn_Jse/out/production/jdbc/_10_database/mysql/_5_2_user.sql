
-- 权限管理：创建不同用户，赋给相应权限（数据库|表|视图 * 操作）

SELECT `host`,`user`,authentication_string FROM mysql.`user`; # mysql存储加密后的密码

-- 创建用户(名字+登录ip作为完整的用户信息)
CREATE USER 'yz'@'localhost' IDENTIFIED BY 'yz';
SHOW CREATE USER 'yz'@'localhost';
-- 删除用户
DROP USER 'yz'@'localhost';

-- 改自己，他人密码
SET PASSWORD = '0';
SET PASSWORD FOR 'yz'@'localhost' = 'yz';

-- 授权 =====================