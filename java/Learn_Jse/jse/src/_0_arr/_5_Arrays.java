package _0_arr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _5_Arrays {
    public static void main(String[] args) {

        Integer[] arrAnother = new Integer[] {1,4,3,5};

        //! copy
        Integer[] arrName = arrAnother;    //just copy ref
        System.out.println("1" + arrName + arrAnother);

        arrName = new Integer[4];
        System.arraycopy(arrAnother, 0, arrName, 1, 3);
        System.out.println("2" + arrAnother + arrName);

        System.out.println("3" + arrAnother + Arrays.copyOf(arrAnother, arrAnother.length));
        // 底层： System.arraycopy
        // 若len > arr.length，新数组尾部添加null

        System.out.println("4" + arrAnother +  arrAnother.clone());

        //! Arrays (wrapped-cls)
        System.out.println(arrName);        // print ref
        System.out.println(Arrays.toString(arrName)); // print each elem

        Arrays.equals(arrName, arrAnother); //need each elem pair same

        Arrays.binarySearch(arrName, 1); //(need:inc order) not found -> ret "-(insertionIndex + 1)"

        //! sort: can change val (compare: String can't change val, return new String
        Arrays.sort(arrAnother);            //paralleSort is more efficient, if multi-processor
        Arrays.sort(arrAnother,1 ,3);
        System.out.println(Arrays.toString(arrAnother)); // low to high

        Arrays.sort(arrAnother, new Comparator<Integer>() { // annoy inner cls, 接口编程
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arrAnother));  // high to low


        // fill
        Arrays.fill(arrName, 1);            //fill all
        Arrays.fill(arrName, 1, 2, 2);    //fill partially
        System.out.println(Arrays.toString(arrName));

        // convert => List
        System.out.println(Arrays.asList(1, 2, arrName).getClass());
        // java.util.Arrays$ArrayList
        // Arrays 的静态内部类 ArrayList
    }
}
