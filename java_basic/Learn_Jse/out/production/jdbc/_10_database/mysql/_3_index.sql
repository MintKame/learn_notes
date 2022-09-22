USE learndb;

SHOW TABLES;
DROP TABLE people;
CREATE TABLE people(
	id INT,
	fname VARCHAR(5),
	lname VARCHAR(5)
);

# 索引：查快，占空间，影响增删改效率

# 哪些列？
# 频繁查（出现在where字段）
# 字段值更新少（否则需要重新找位置）
# 唯一性差不适合创建索引（如，性别）

# 若值不重复，优先使用唯一索引

# 在创建表时，标记为主键的，会创建主键索引；标记为unique的，会创建unique索引
# 添加  索引(普通, 唯一)  ======================
CREATE INDEX fname_i1 ON people(`fname`);
CREATE UNIQUE INDEX fname_i2 ON people(`fname`);

ALTER TABLE people ADD INDEX lname_i1(`lname`);
ALTER TABLE people ADD UNIQUE INDEX lname_i2(`lname`);

# 添加主键索引
ALTER TABLE people ADD PRIMARY KEY(id); # 只能有一个

# 查询索引 ======================================
SHOW INDEXES FROM people;

# 删除    索引(普通,唯一)
DROP INDEX fname_i1 ON people; 

ALTER TABLE people DROP INDEX fname_i2;

# 删除主键索引
ALTER TABLE people DROP PRIMARY KEY;