USE learndb;
SHOW TABLES;
# 数据的自我复制 (蠕虫复制)
# 插入海量数据，为了测试语句效率
SELECT * FROM student;

INSERT INTO student
	SELECT * FROM student;
	
# 删重复记录 ===========================
SELECT * FROM student;
SELECT * FROM student_tmp;
DROP TABLE student_tmp;
# 1. 临时表 复制 表结构 和新数据（已去重）
CREATE TABLE student_tmp LIKE student;

INSERT INTO student_tmp 
	SELECT DISTINCT * FROM student;
# 2. 清空旧表
DELETE FROM student;
# 3. 插入新数据，删临时表
INSERT INTO student
	SELECT * FROM student_tmp;
DROP TABLE student_tmp;
 