USE learndb;

/* 约束 not null
	primary key
	unique
	foreign key
	check
*/

# not null
CREATE TABLE s1(
	id INT NOT NULL,
	`name` VARCHAR(30) 
); 
INSERT INTO s1 VALUES(1, 'a');
INSERT INTO s1 VALUES(NULL, 'a'); # 不可为null

# unique =====================================
CREATE TABLE s3(
	id INT UNIQUE,
	`name` VARCHAR(30) 
);
INSERT INTO s3 VALUES(1, 'a');
INSERT INTO s3 VALUES(1, 'b'); # 不可重复

# primary key =====================================
CREATE TABLE s2(
	id INT PRIMARY KEY,
	`name` VARCHAR(30) 
);
INSERT INTO s2 VALUES(1, 'a');
INSERT INTO s2 VALUES(NULL, 'a'); # 不可为null
INSERT INTO s2 VALUES(1, 'b'); # 不可重复

# 复合主键 =====================================
CREATE TABLE s4(  # 不可
	id INT PRIMARY KEY,
	`name` VARCHAR(30) PRIMARY KEY 
);

CREATE TABLE s4(  
	id INT ,
	`name` VARCHAR(30), 
	PRIMARY KEY(id, `name`)
);

DESC s4;

# foreign key：innodb才支持 =====================================
CREATE TABLE s5( # 主表
	id INT PRIMARY KEY, # 被引用字段 必为unique或主键
	`name` VARCHAR(30) 
);

CREATE TABLE s6( # 从表
	id5 INT, # 引用的字段 必须和主表同类型（长度可不同）
	FOREIGN KEY(id5) REFERENCES s5(id)
);

INSERT INTO s5 VALUES(111, 'aaa');
INSERT INTO s6 VALUES(222);
INSERT INTO s6 VALUES(111); # 从表数据的外键，必须在主表存在，或为null
INSERT INTO s6 VALUES(NULL);

DELETE FROM s5 WHERE id=111; # 主表被引用的数据，不可直接删

# check: 5.7无效 =====================================
# 代替：类型设置为 ENUM('man', 'woman') 5.7支持
CREATE TABLE s7(  
	id INT ,
	sex VARCHAR(6) CHECK (sex IN ('man', 'woman'))
);

DESC s7; 
INSERT INTO s7 VALUES(1, 'man');
INSERT INTO s7 VALUES(1, 'unknow');

# 自增 =====================================
CREATE TABLE s8(  
	id INT PRIMARY KEY AUTO_INCREMENT, # 只能用在key上(常主键)
	`name` VARCHAR(6)
);
SELECT * FROM s8;

INSERT INTO s8 VALUES(NULL, 'a');
INSERT INTO s8(`name`) VALUES('b');
INSERT INTO s8(id,`name`) VALUES(NULL, 'c');
# 更改初始值
ALTER TABLE s8 AUTO_INCREMENT = 10;

# 若自增字段 指定了值，之后的默认值从指定值开始