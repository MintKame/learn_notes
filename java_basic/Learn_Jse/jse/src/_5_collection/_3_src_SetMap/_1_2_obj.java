package _5_collection._3_src_SetMap;

import java.util.Objects;

class Obj1{
    String name;

    public Obj1(String name) {this.name = name;}

    @Override
    public String toString() {return "Obj1(" + name + ')';}
}

class Obj2{
    String name;

    public Obj2(String name) {this.name = name;}

    // equals, hashCode 自动生成
    // 选择name，使相同name的Obj2： hashCode()相同， equals()为true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obj2 obj2 = (Obj2) o;
        return Objects.equals(name, obj2.name);
    }

    @Override
    public int hashCode() {return Objects.hash(name);}

    @Override
    public String toString() {return "Obj2(" + name + ')';}

    public void setName(String name) {this.name = name;}
}
