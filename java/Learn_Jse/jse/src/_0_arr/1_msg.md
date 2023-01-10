### concepts
+ JDK: development kit
+ JRE: runtime environment
+ JVM: virtual machine -> compile once, use anywhere
(diff hardware, diff jvm)

+ relationship: contain


### using CLI
bf: set path to jdk bin dir; 

set classpath to current dir

`javac clsName.java(src)`

`java clsName(byte code) para..`

+ what if not pass para to main ?
 
  call "new args[0]" rather than null

### pkg
why use pkg:  name conflict;

protect cls(only same pkg can access);

distribute software

+ name: 

  com.companyname.projectname.modelname;

    eg: com.yz.bingo.user;

+ 2-ways import cls

    import java.util.Scanner; // recommand

    import java.util.*;

### 8*基本数据类型

+ 1byte = 1字节 = 8 bit(位)

|         | 大小 | 取值范围       |
| ------- | ---- | -------------- |
| short   | 2    | -2^15 ~ 2^15-1 |
| int     | 4    | -2^31 ~ 2^31-1 |
| long    | 8    | -2^63 ~ 2^63-1 |
| byte    | 1    | -2^7 ~ 2^7-1   |
| char    | 2    |                |
| float   | 4    |                |
| double  | 8    |                |
| boolean | 1/4  | true / false   |

 
 