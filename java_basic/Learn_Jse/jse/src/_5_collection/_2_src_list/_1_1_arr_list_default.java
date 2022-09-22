package _5_collection._2_src_list;

import java.util.ArrayList;

public class _1_1_arr_list_default {
    // arrList 内部维护数组
    // transient Object[] elementData;
    public static void main(String[] args) {
        // 无参构造：0 -> 10 -> *1.5 （jdk7中初始cap为10）
        ArrayList list = new ArrayList(); // a, size/cap = 0/0
        list.add(1); // b, 1/10
        list.add(2); // c, 2/10

        for (int i = 3; i <= 10; i++) {
            list.add(i);
        }
        // 10个cap已用完, 10/10
        list.add(11); // d, 11/15

        /* a. default ctor
            public ArrayList() {
                this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
                // private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
                // size/cap = 0/0
            }
        */

        // add, 扩容
        //! 1. 计算 minCap: add后的新size / 无参构造首次设为10
        /*     public boolean add(E e) {
                    // 加入元素后，需要满足 cap > 新size（元素个数）
                    // minCap=新size
                    // b 0+1 | c 1+1 | d 10+1
                    ensureCapacityInternal(size + 1);
                    elementData[size++] = e;
                    return true; // 添加成功
            }

            private void ensureCapacityInternal(int minCapacity) {
                ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
            }

            private static int calculateCapacity(Object[] elementData, int minCapacity) {
                if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                    return Math.max(DEFAULT_CAPACITY, minCapacity);

                    // b minCap=max(10, 1) = 10
                    // 当数组为{}时，minCap 为 10
                    // 因为，若扩容为新size = 1，下次add仍需扩容
                }
                return minCapacity;
                // minCap=新size
                // c 2 | d 11
            }*/
        //! 2. 不足则扩容
        /*
            private void ensureExplicitCapacity(int minCapacity) {
                modCount++;
                // overflow-conscious code

                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
                // bd：数组长度不足minCap，扩容
                // c不用扩容，到此结束
            }*/
        //! 3. 扩容 newCap = max(minCap, 1.5*oldCap)
        /*
            private void grow(int minCapacity) { // b 10 | d 11
                // overflow-conscious code

                // oldCap
                // b 0  | d 10
                int oldCapacity = elementData.length;

                // newCap = 1.5*oldCap
                // b 0 | d 15
                int newCapacity = oldCapacity + (oldCapacity >> 1);

                // newCap = max(minCap, newCap)
                // b 10 | d 15
                if (newCapacity - minCapacity < 0)
                    newCapacity = minCapacity;

                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                // minCapacity is usually close to size, so this is a win:
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
        */
    }
}
