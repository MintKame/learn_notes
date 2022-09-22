USE dreamhom;

SELECT * FROM staff;
SELECT * FROM propertyforrent; 
# scaler 单行单列：作为一个值 ==================================================== 
# 员工 Ford 负责的房产 
SELECT staffNo FROM staff  # 员工Ford 的编号
	WHERE lName = 'Ford';

SELECT * FROM propertyforrent
	WHERE staffNo = (
		SELECT staffNo FROM staff 
		WHERE lName = 'Ford'
	);
# 员工SG14的lName 和他负责的房产(按列的顺序)
SELECT lName FROM staff WHERE staffNo = 'SG14';

SELECT  (SELECT lName FROM staff WHERE staffNo = 'SG14'), propertyforrent.* FROM propertyforrent
	WHERE  staffNo = 'SG14';

# 多行单列：作为一个数组 ========================================================= 
# 负责 House类型房产 的所有员工
SELECT staffNo FROM propertyforrent  #  负责 House类型房产 的员工编号
	WHERE `type` = 'House';
	
SELECT * FROM staff
	WHERE staffNo IN (
		SELECT staffNo FROM propertyforrent 
		WHERE `type` = 'House');
		
# 工资高于 B003 部门所有员工 的员工
SELECT salary FROM staff  # B003 部门所有员工工资
	WHERE branchNo = 'B003';

SELECT * FROM staff 
	WHERE salary > ALL(
		SELECT salary FROM staff 
		WHERE branchNo = 'B003'); 
		
SELECT * FROM staff  # 或者
	WHERE salary > (
		SELECT MAX(salary) FROM staff 
		WHERE branchNo = 'B003');
# 单行多列：作为一条记录 或者 用于多列匹配  ===================================
# 和SG37同性别，工资的员工
SELECT sex, salary FROM staff
	WHERE staffNo = 'SG37';
	
SELECT * FROM staff
	WHERE (sex, salary) = (
		SELECT sex, salary FROM staff
		WHERE staffNo = 'SG37'
	);

# 多行多列：作为一个表 =========================================================== 
# 用在from子句
# 查找工资大于部门平均工资的 职员 
SELECT branchNo, AVG(salary) AS avg_s FROM staff # 每个部门及其平均工资
		GROUP BY branchNo;
		
SELECT * 
	FROM staff, (
		SELECT branchNo, AVG(salary) AS avg_s FROM staff 
		GROUP BY branchNo) s2 # 临时表必须起别名
	WHERE staff.`branchNo` = s2.`branchNo` AND staff.salary > s2.avg_s;
	
	
# 所有员工，员工工资不高于其部门的平均工资
# 所有部门的平均工资
SELECT branchNo, AVG(salary) AS avg_salary
	FROM staff
	GROUP BY branchNo;
	
SELECT staffNo, fName, salary, branchNo, avg_salary
	FROM staff NATURAL JOIN (
		SELECT branchNo, AVG(salary) AS avg_salary
		FROM staff
		GROUP BY branchNo
	) tmp
	WHERE salary <= avg_salary;
