/*
 * @Author: your name
 * @Date: 2021-05-27 15:56:50
 * @LastEditTime: 2021-05-27 15:57:45
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\4_3_str_view.cpp
 */

/*
string_view和string的关系有点像常量指针和对象的关系

用string初始化string_view时，string不会被拷贝，而仅仅被“绑定”，类似于指针指向对象，因而十分高效

无法通过string_view修改它绑定的string，但可以修改string_view使其绑定到别的string

修改一个string，所有绑定它的string_view的内容也会跟着变

若string_view和它绑定的string生存期不一致，可能会导致一些问题

作为“观察者”，string_view虽然不能像string那样提供remove、push等修改字符串的操作，但是可以通过remove_prefix和remove_suffix来修改“观察的范围”

string_view的substr操作也不会拷贝字符串，因而十分高效
*/