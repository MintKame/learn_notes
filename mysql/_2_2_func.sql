
# 流程控制 (此处select不算子查询) ================================================ 
SELECT IF(TRUE, 'aaa', 'bbb'); # $1 为真，则返回 $2, 否则$3
SELECT IFNULL('aaa', 'bbb');   # $1 为空，则返回 $2, 否则$1
SELECT IFNULL(NULL, 'bbb');

# 根据房屋类型返回不同值 
SELECT propertyNo, `type` AS '类型' FROM propertyforrent;
 
SELECT propertyNo, (SELECT CASE
	WHEN `type`='House' THEN '房子'
	WHEN `type`='Flat' THEN '公寓'
	ELSE '其他' END) AS '类型'  # 注意，判断条件可以考虑多列
FROM propertyforrent;
	
# 若房屋数为null，则显示未知 
SELECT propertyNo, rooms 
	FROM propertyforrent;
	
SELECT propertyNo, IFNULL(rooms, '未知') AS rooms
	FROM propertyforrent;
	
# 查clientNo及maxRent，其值低于500或为NULL
SELECT clientNo, maxRent FROM `client`;

SELECT clientNo, maxRent FROM `client`
	WHERE maxRent IS NULL OR maxRent<500 ;
	
SELECT clientNo, maxRent FROM `client`
	WHERE IFNULL(maxRent, 0) < 500;

# 获取数据库信息 ================================================================ 
SELECT USER();  # 所有登录mysql的用户
SELECT DATABASE();

# 数学，字符串 见 图片

# 统计
# 不同城市：总房产数，平均每个房产的房间数
SELECT city, COUNT(*) AS total_property, AVG(rooms) AS avg_roms FROM propertyforrent
GROUP BY city;

# 业主个数
SELECT ownerNo FROM propertyforrent;
SELECT DISTINCT ownerNo FROM propertyforrent;

SELECT COUNT(*), COUNT(ownerNo),COUNT(DISTINCT ownerNo) FROM propertyforrent; 
# 7，所有的行数
# 6, 不计入列为null
# 4，不计入列为null，并且去重

# 租金:总和, 最大差值
SELECT SUM(rent), MAX(rent)-MIN(rent) FROM propertyforrent;

# 时间 =========================================================================
# 获取当前时间
SELECT CURRENT_DATE() FROM DUAL; # dual 为亚元表 
SELECT CURRENT_TIME() FROM DUAL;
SELECT CURRENT_TIMESTAMP() FROM DUAL;
SELECT NOW() FROM DUAL; # insert增加数据时，可以使用

# unix
SELECT UNIX_TIMESTAMP() FROM DUAL; # 1970-1-1 到现在秒数
SELECT FROM_UNIXTIME(0) FROM DUAL; # UNIX_TIMESTAMP 转换为 日期
SELECT FROM_UNIXTIME(0, '%Y-%m-%d') FROM DUAL; # （可以指定格式）
# 开发中，存整数，使用时，用FROM_UNIXTIME转化为时间

# 从时间中，提取一部分
SELECT YEAR(NOW()) FROM DUAL; 
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
SELECT HOUR(NOW()) FROM DUAL;
SELECT MINUTE(NOW()) FROM DUAL;
SELECT SECOND(NOW()) FROM DUAL;

# 获取某年第一天
SELECT MAKEDATE(2000,1);  

# 时间差(参数可以为time，date，timestamp)
SELECT DATE_ADD(NOW(), INTERVAL 1, YEAR) FROM DUAL;
SELECT DATE_SUB(NOW(), INTERVAL 1, YEAR) FROM DUAL;
SELECT DATEDIFF(NOW(), '2001-5-26'); # 2个时间之差，天数
SELECT TIMEDIFF(CURRENT_TIME, '0:0:0'); 

SELECT DATE_ADD(NOW(), INTERVAL 1, YEAR) FROM DUAL;

# eg. 查50岁内的员工
SELECT * FROM staff;

SELECT * FROM staff 
	WHERE `DOB` > DATE_SUB(NOW(), INTERVAL 50 YEAR);
# 查生日在其月最后10天内的员工
SELECT *, LAST_DAY(`DOB`) - 10 FROM staff
	WHERE DATE(`DOB`) > LAST_DAY(`DOB`) - 10;

# 加密 ========================================================================= 
SELECT MD5('hahaha') FROM DUAL; # 32位字符串

SELECT PASSWORD('hahaha') FROM DUAL; # mysql 用户密码使用password加密

# eg
CREATE TABLE users(
	`id` INT,
	`password` CHAR(32)
);

INSERT INTO users VALUES('123', MD5('hahaha')); # 用户注册时，密码存储为密文

SELECT * FROM users WHERE `id`='123' AND `password`=MD5('hahaha'); # 用户登录时，使用密文查找


