
-- 权限管理：创建不同用户，赋给相应权限（数据库|表|视图 * 操作）

SELECT `host`,`user`,authentication_string FROM mysql.`user`; # mysql存储加密后的密码

-- 创建用户(名字+登录ip作为完整的用户信息)
CREATE USER 'yz1'@'localhost' IDENTIFIED BY 'yz';
SHOW CREATE USER 'yz'@'localhost';

-- 通配符指定 ip范围
CREATE USER 'yz3'@'%' IDENTIFIED BY 'yz';
CREATE USER 'yz1'@'192.168.0.%' IDENTIFIED BY 'yz';

-- 删除用户
DROP USER 'yz'@'localhost';

-- 改自己，他人密码
SET PASSWORD = '0';
SET PASSWORD FOR 'yz'@'localhost' = 'yz';

-- 授权 =====================================================
-- on 可以用通配符
GRANT SELECT ON * TO 'yz'@'localhost'; # 所有数据库的所有对象（表，视图，存储过程）
GRANT UPDATE,INSERT ON *.* TO 'yz'@'localhost'; # 
GRANT UPDATE,INSERT ON javabook.* TO 'yz'@'localhost'; # 
GRANT DELETE ON javabook.student TO 'yz'@'localhost';

-- 某对象 的 所有权限
GRANT ALL PRIVILEGES ON * TO 'yz'@'localhost';

-- 若不存在则创建用户，存在则改密码
GRANT SELECT ON * TO 'yz'@'localhost' IDENTIFIED BY 'yzz';

-- 回收权限  =====================================================
REVOKE SELECT ON javabook.* FROM 'yz'@'localhost' ;
REVOKE ALL ON javabook.* FROM 'yz'@'localhost' ;
 
