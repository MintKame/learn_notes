USE dreamhom;

SELECT * FROM staff;
SELECT * FROM propertyforrent;

# 多表 =============================================
# 自连接: 同一张表 作为 2张表使用；需要给2表起别名
# 查找同薪水的同事
SELECT s1.`lName` AS name1, s2.`lName` AS name2 
	FROM staff AS s1, staff AS s2
	WHERE s1.`staffNo` != s2.`staffNo` AND s1.`salary` = s2.`salary`;

# 笛卡尔积：2张表的 每行 进行组合，同名的列都显示
SELECT * FROM staff, propertyforrent;
	 
SELECT * FROM staff, propertyforrent
	WHERE staff.`staffNo` = propertyforrent.`staffNo`; # 若有重复列名
	

# 自然连接：同名列 要求值相同，只显示一列（区别笛卡尔）
SELECT * FROM staff NATURAL JOIN propertyforrent; # 要求 staffNo 和 branchNo 相同

# 内连接: 默认为 inner join
# 外连接：
SELECT * FROM staff OUTER JOIN propertyforrent
	WHERE staff.`staffNo` = propertyforrent.`staffNo`;

