package _2_cls_if_abs_enum;

//can't extend, all enum extends:
//  public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable
enum Sex2{
    // simplify: static final obj && call ctor
    //           must at first
    MALE("男"),    // use , to separate
    FEMALE("女"),
    UNKNOW; // no-para ctor, can no ()

    private String desc;

    // ctor visibility: must private / default
    private Sex2(String desc){
        this.desc = desc;
    }

    private Sex2(){}
}

public class  _7_enum_keyword {
    public static void main(String[] args) {
        Sex2 male = Sex2.MALE;
        Sex2 female = Sex2.FEMALE;
        // name: same*3:
        System.out.println(male.name());// male.name = "MALE"
        System.out.println(male.toString());
        System.out.println(male);

        //
        System.out.println(male.ordinal()); // order in enum (from 0
        System.out.println(male.compareTo(female)); // male.ordinal - female.ordinal
        // can use both ==, equals()

        // get all const in enum
        Sex2[] values = Sex2.values();
        for (Sex2 s : values)
            System.out.println(s);

        // str -> enum obj
        Sex2 value = Sex2.valueOf("MALE");
        System.out.println(value);
    }
}