USE learndb;

SHOW TABLES; 

CREATE TABLE teacher(
	id INT,
	`name` VARCHAR(10)
);

SELECT * FROM teacher;

# 事务：一组dml语句，作为整体执行，要么都成功，要么都失败
# 必须使用innodb存储引擎
-- 开启事务（2种方法）
START TRANSACTION; 
SET autocommit=off; # 默认为on，即每条语句，都会 自动开启transaction，在执行完提交（不能rollback）

INSERT INTO teacher VALUES(1, 'aaa');
SAVEPOINT a; -- 设置保存点a
INSERT INTO teacher VALUES(2, 'bbb');
SAVEPOINT b; -- 设置保存点b
INSERT INTO teacher VALUES(3, 'ccc'); 

SELECT * FROM teacher; # 3条
-- 回退 到某个保存点
ROLLBACK TO b; 
SELECT * FROM teacher; # 2条

ROLLBACK TO a; 
SELECT * FROM teacher; # 1条

-- 直接回退到开启事务时的状态（相当于，在开始事务时，创建了一个保存点）
ROLLBACK;
SELECT * FROM teacher; # 0条

# =======================================================================
DELETE FROM teacher;
SELECT * FROM teacher;

START TRANSACTION;

INSERT INTO teacher VALUES(1, 'aaa');
SAVEPOINT a; -- 设置保存点a
INSERT INTO teacher VALUES(2, 'bbb');
SAVEPOINT b; -- 设置保存点b
INSERT INTO teacher VALUES(3, 'ccc');
SAVEPOINT c; # 3条

# 不能回退：why？
#   	已经回退到 某点之前的点：后面的保存点被删除
# 	已经提交：结束事务，删保存点，释放锁，数据生效（其他会话可见新数据）
ROLLBACK TO b; # 2条
SELECT * FROM teacher;
ROLLBACK TO c; # 错误

COMMIT;
ROLLBACK TO a; # 错误
ROLLBACK; # 成功，但无效
SELECT * FROM teacher;
