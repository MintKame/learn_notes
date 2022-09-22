# RESTful

+ 一种软件架构的风格
+ **Re**presentational **S**tate **T**ransfer 
+ 表现层（view+controller）资源状态转移


+ 资源 

  + 服务器上一个可命名的抽象概念（类，html，css，图片等） 

  + 与面向对象类似，以名词来组织，一个资源可以由一个或多个URI来标识。

+ 状态转移

  + 在客户端和服务器端间转移（transfer）代表资源状态的表述。
  + 通过转移和操作资源的表述，来间接实现操作资源的目的。

+ URL统一风格

  + 各单词用斜杠分开，不用问号拼接请求参数，

  + 把 发送给服务器的数据 作为 URL 地址的一部分，

  + 请求路径：表示资源，只要操作的资源一样，访问的url就一样
  
| 操作 | 传统方式         | REST风格         |
| ---- | ---------------- | ---------------- |
| 查   | getUserById?id=1 | user/1（get）    |
| 增   | saveUser         | user（post）     |
| 删   | deleteUser?id=1  | user/1（delete） |
| 改   | updateUser       | user（put）      |
 