USE dreamhom;

SHOW TABLES;

SELECT * FROM propertyforrent;

# where/having 的条件 ======================================
SELECT * FROM propertyforrent 
	WHERE rooms > 3;

# 日期可以直接比较
SELECT * FROM staff
	WHERE dob > '1960-1-1';

SELECT * FROM propertyforrent 	
	WHERE rooms BETWEEN 3 AND 5; # 闭区间

SELECT * FROM propertyforrent 	
	WHERE rooms IN (1, 2, 3);

SELECT * FROM propertyforrent 
	WHERE rooms IS NULL;
	
# 模糊匹配：%（>=0个）  _（1个）
# 名字为A开头的业主
SELECT * FROM privateowner
	WHERE fname LIKE 'A%';
# 名字不带A的业主(不区分大小写)
SELECT * FROM privateowner
	WHERE fname NOT LIKE '%A%';


# 单表 =============================================================================
# 有标号：当同时使用这几种语句时，注意顺序

# 别名：AS 可省略
# 引用时可用别名，也可用原名
# 若有空格，需要用"" 或`` 括起来

# 去重：查询不重复的owner号
SELECT DISTINCT ownerNo AS `total` FROM propertyforrent; # distinct 去重（若选择的所有字段都相同），默认不去重

# 2. 排序：按房屋*租金降序 =========================================================
SELECT ownerNo, (rooms * rent) AS total  FROM propertyforrent
	ORDER BY  total DESC; # desc | asc, 降升，默认升

SELECT ownerNo, rooms, rent FROM propertyforrent # 按房屋数升序-租金升序
	ORDER BY  rooms, rent ; 
	
# 1. 分组：不同城市：房产数，平均每个房产的房间数,只显示大于1个房产的城市 ===================
SELECT city, COUNT(*) AS total_property, AVG(rooms) AS avg_roms FROM propertyforrent
	GROUP BY city				# 分组
	HAVING total_property > 1; 		# 限制分组结果
	# 分组后，每组占一行，因此选择的列要满足（是被分组的属性、由函数作用于某些属性）

# 3. 分页: 每页五行 ===============================================================================
# 公式：每页行数*(第几页-1) , 每页行数 
SELECT * FROM propertyforrent
	LIMIT 0,5;
SELECT * FROM propertyforrent
	LIMIT 5,5;
	
# 流程控制 (此处select不算子查询) =========================================================== 
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
