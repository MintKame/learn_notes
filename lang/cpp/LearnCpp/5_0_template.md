# 概念
1. 编程：写程序，处理数据

   元编程：写程序，处理程序

   泛型编程：写程序，处理不同类型的数据

2. C++: 模板 实现 元编程，元编程 实现 泛型编程

3. advantage: 
    save typing
    save space
    easy to maintain

4. when use: define lib; diff type same op.

# 使用
1. 定义模板：
    + 写一个非泛型函数
    + 转换
    + 注意：声明 与 定义必须在一起（not 分在 .h和.cpp）

2. 实例化：函数/类 模板 -> 实例 函数/类（之后，才是真正的函数/类）
    编译:模板不是类或函数，编译时不生成代码；
        在确定模板的参数类型时，模板实例化，会生成代码。
    
    when: 实例化在编译时，非运行时，so是静态binding

    两种实例化：显式实例化和隐式实例化。

3. 特殊：
    + 参数中，非类型（如一个变量）也可泛型化（见func_tmp，cls_tmp 也可使用）
    + 指定默认类型，非类型的默认值（见cls_tmp，func_tmp 不可用）
        `template <typename T = int, int capacity = 10>`

# inherit
cls -> T1<int> (instance cls)
T1  -> cls
T2 -> T1
can't: cls -> T1 