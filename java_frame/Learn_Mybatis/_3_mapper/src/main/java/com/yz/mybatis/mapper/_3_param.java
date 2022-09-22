package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student3;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.ParamNameResolver;

import java.util.List;
import java.util.Map;

public interface _3_param {
    // 以下，根据 name 和 age 查学生（返回第一个结果）的不同方式（查询结果 不考虑school属性）

    Student3 findByNameAge(@Param("name")String name, Integer age);
    // xml 取参：name/param1     1/param2

    //! obj
    Student3 findByObj(Student3 student);
    // xml 取参：对象的属性名

    Student3 findByNameObj(@Param("name")String name, @Param("student")Student3 student);
    // 此处obj只提供age
    // name/param1     student.age/param2.age

    //! map
    Student3 findByMap(Map<String, Object>map);
    // map的key

    Student3 findByNameMap(@Param("name")String name, Map<String, Object>map);
    // 此处map只提供age
    // name/param1     1.age/param2.age

    //! collection
    Student3 findByList(@Param("name")String name, List<Integer> age);
    // name/param1     1[0]/param2[0]
}
/*（术语：param为参数，有属性 index，name，实参
! xml 取参规则
    ! 单个参数：#{任意名}
    ! 多个参数：#{（参数索引 / @Param指定的名字）或（param1...paramN）}
        底层：封装成 一个map
            key：（参数索引 / @Param指定的名字）或（param1...paramN）
            value：param的实参
    ! 单个对象：#{obj的属性名} 取出 传入的pojo 的属性值
        POJO：多个参数 是业务模型中的数据
        TO：  如果 多个参数不是业务模型中的数据，但经常使用，编写 TO（Transfer Object）用于传输
    ! 单个Map：#{map的key} 取出 map中对应的值
        应用：如果 多个参数不是业务模型中的数据，且不经常使用，传入map
    ! eg
        func(@Param("id")Integer id, String lastName);
            取值：id==>#{id/param1}   lastName==>#{1/param2}

        func(Integer id, @Param("e")Employee emp);
            取值：id==>#{0/param1}    lastName===>#{param2.lastName/e.lastName}
 */
/*（术语：param为参数，有属性 index，name，实参
! 原理：ParamNameResolver 解析参数，封装为map
eg: func(@Param("name") String name, Integer age);
    实际参数 ("yz", 20)    */
/*
! 确定 names：param的index = param的名字
    eg：{0=name, 1=1}
    ! 遍历params：获取名字
    final SortedMap<Integer, String> map = new TreeMap<Integer, String>();
    int paramCount = paramAnnotations.length;
    for (int paramIndex = 0; paramIndex < paramCount; paramIndex++) {
      String name = null;
      ! param标注了@Param，名字为注解值
      for (Annotation annotation : paramAnnotations[paramIndex]) {
        if (annotation instanceof Param) {
          hasParamAnnotation = true;
          name = ((Param) annotation).value();
          break;
        }
      }
      ! param 没标注 @Param，
      if (name == null) {
        ! 全局配置：useActualParamName（jdk1.8）：名字为 参数名
        if (config.isUseActualParamName()) {
          name = getActualParamName(method, paramIndex);
        }
        ! 名字为 param的index
        if (name == null) {
          name = String.valueOf(map.size());
        }
      }
      map.put(paramIndex, name);
    }
    names = Collections.unmodifiableSortedMap(map);*/

/*
! param的名字 映射到 param的实参
! 效果：sql中引用 #{@Param指定的名字} 或 #{paramN}
public Object getNamedParams(Object[] args) {
    final int paramCount = names.size();
    ! 无实参：返回 null
    if (args == null || paramCount == 0) {
      return null;
    ! 一个实参 且没@Param：返回param的实参
    } else if (!hasParamAnnotation && paramCount == 1) {
      return args[names.firstKey()];
    } else {
    ! 多个实参，或有 @Param：返回map NamedParams
      eg：names          {0=name, 1=1}
          NamedParams    {name="yz", 1=20, param1="yz", param2=20}

      final Map<String, Object> param = new ParamMap<Object>();
      int i = 0;
      ! 遍历names集合 {0=name, 1=1}
      for (Map.Entry<Integer, String> entry : names.entrySet()) {
        ! NamedParams：param的名字 = param的实参 （names的value = 实参[names的key]）
             (names：   param的index = param的名字
        param.put(entry.getValue(), args[entry.getKey()]);

        ! NamedParams：额外：param的名字，使用（param1...paramN）
        final String genericParamName = GENERIC_NAME_PREFIX + String.valueOf(i + 1);
        // ensure not to overwrite parameter named with @Param
        if (!names.containsValue(genericParamName)) {
          param.put(genericParamName, args[entry.getKey()]);
        }
        i++;
      }
      return param;
    }
  }
} */

