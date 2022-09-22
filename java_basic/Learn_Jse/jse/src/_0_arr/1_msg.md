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