USE dreamhom;

SHOW TABLES; 

-- view 虚拟表，由查询定义，只产生结构文件，不产生数据文件。
-- 安全：对某类用户隐藏列
-- 性能：常执行的查询，每次join效率低；建立视图，避免使用join
-- 灵活：想废弃的表被引用过多，不能删改。则：保留旧表，视图作为新表，新应用引用新表，旧应用不变

-- 增: 显示房产号，员工名，客户名 ====================================
CREATE VIEW view1 AS (
	SELECT propertyforrent.`propertyNo`, staff.`fName` AS staffName, privateowner.`fName` AS ownerName
	FROM propertyforrent, staff, privateowner
	WHERE propertyforrent.ownerNo = privateowner.`ownerNo` AND propertyforrent.`staffNo` = staff.`staffNo`
);
-- 删
DROP VIEW view1;
-- 改
ALTER VIEW view1 AS (
	SELECT propertyforrent.`propertyNo`, staff.`fName` AS staffName, privateowner.`fName` AS ownerName
	FROM propertyforrent, staff, privateowner
	WHERE propertyforrent.ownerNo = privateowner.`ownerNo` AND propertyforrent.`staffNo` = staff.`staffNo`
);
-- 查视图的数据（同表）
SELECT * FROM view1;
-- 查某视图的结构
DESC view1;
-- 查某视图是如何创建的
SHOW CREATE VIEW view1;

-- 每次查询的数据来自基表=========================================
-- 改基表影响视图 
-- 改视图影响基表
SELECT * FROM view1;
UPDATE staff SET fName = 'Maaaaa' WHERE staffNo = 'SA9';
SELECT * FROM view1;

SELECT * FROM staff;
UPDATE view1 SET staffName = 'oooooo' WHERE propertyNo = 'PA14';
SELECT * FROM staff;

-- 可基于视图 创建新视图
