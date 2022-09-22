USE learndb;
SHOW TABLES;
# mysql的表类型 由 存储引擎 决定
# 查看所有存储引擎 
SHOW ENGINES;

# 创建表
CREATE TABLE s8(
	id INT
) ENGINE INNODB;

# 显示表的engine
SHOW CREATE TABLE student;

# 修改表的engine
ALTER TABLE s8 ENGINE MYISAM;

# myisam 不支持事务：语句success，但无效 ==================
ALTER TABLE s8 ENGINE MYISAM;

DELETE FROM s8;

START TRANSACTION;
SAVEPOINT a;

INSERT INTO s8 VALUES(1);
SELECT * FROM s8;

ROLLBACK TO a; 
SELECT * FROM s8; # 仍为1条
# memory  ==================================================
# 数据存在内存，每个memory表只实际对应1个磁盘文件
DELETE FROM s8;

ALTER TABLE s8 ENGINE MEMORY;
SELECT * FROM s8;

INSERT INTO s8 VALUES(2);
SELECT * FROM s8; # 1条

# net stop mysql
# net start mysql

# 重启mysql服务，数据丢失，但表结构还在
SELECT * FROM s8; # 无记录