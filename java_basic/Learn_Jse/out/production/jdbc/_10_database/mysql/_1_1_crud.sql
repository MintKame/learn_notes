
# 登录（dos）
# mysql -h 主机名 -P 端口名 -u 用户名 -p密码 
# 备份（dos）=============================================
# mysqldump -u用户名 -p密码 -B 数据库1 数据库2 > xx.sql (某些数据库)
# mysqldump -u用户名 -p密码    数据库  表1 表2 > xx.sql (某个数据库 的 某些表)
# 恢复（mysql命令行）
# source xx.sql

# 改密码出错 =============================================
# 1、解决方式：
SET PASSWORD = '123456'
# 2、解决方式：
ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';

# 连接mysql：https://blog.csdn.net/pw1623/article/details/107139788

# 出错查询(dos)       mysqld --console 


# 增删改查
# 数据库 =============================================
CREATE DATABASE learnDB 
	CHARACTER SET=utf8 COLLATE utf8_general_ci;
# CHARACTER SET，字符集，默认utf8 
# COLLATE 字符集的校对规则，
# 	不区分大小写utf8_general_ci（默认）
# 	区分大小写  utf8_bin

DROP DATABASE learnDB;

ALTER DATABASE learndb CHARACTER SET=utf8;

SHOW DATABASES;
SHOW CREATE DATABASE learnDB;


# 表 =============================================

USE learnDB;

CREATE TABLE IF NOT EXISTS student( # 约束见1_2
	id INT NOT NULL,
	`name` VARCHAR(30) # 反引号：规避关键字
) CHARACTER SET=utf8 COLLATE utf8_general_ci ENGINE INNODB; # engine 引擎
# 若不指定CHARACTER SET 和 COLLATE ，则同database

DROP TABLE student;

ALTER TABLE student CHARACTER SET=utf8;
RENAME TABLE students TO student;

DESC TABLE student;

# 表的列 =============================================

ALTER TABLE student ADD (
	age INT,
	class INT
);

ALTER TABLE student DROP class;
ALTER TABLE student DROP age;

ALTER TABLE student MODIFY id INT NOT NULL;  # 修改列
ALTER TABLE student CHANGE `name` student_name VARCHAR(30); # 修改列名


# 表的行（记录）=============================================

INSERT INTO student(id, `name`) 
	VALUES(111, 'a');  # 字符和日期需要在''内
INSERT INTO student(id) 
	VALUES(222); # 可以不设置某些值（默认值、空）
INSERT INTO student(id, `name`) 
	VALUES(333, 'c'), (444, 'd'); # 多条
INSERT INTO student 
	VALUES(2019210902, 'yz'); # 需要值和属性顺序一致（不推荐）

DELETE FROM student WHERE id=2019210902;
# delete from student; # 删所有记录，成为空表

UPDATE student SET id=id+111,`name`='e' WHERE id=444;

SELECT * FROM student;

