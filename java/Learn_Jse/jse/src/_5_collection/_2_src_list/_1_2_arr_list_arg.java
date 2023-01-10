package _5_collection._2_src_list;

import java.util.ArrayList;

public class _1_2_arr_list_arg {
    public static void main(String[] args) {
        // 有参构造：x -> *1.5
        ArrayList list = new ArrayList(5); // a, size/cap = 0/5
        list.add(1); // b, 1/5

        for (int i = 2; i <= 5; i++) {
            list.add(i);
        }
        // 5个cap已用完, 5/5

        list.add(6); // c, 6/7

    /* a. ctor
        public ArrayList(int initialCapacity) {
            if (initialCapacity > 0) {
                this.elementData = new Object[initialCapacity];
            } else if (initialCapacity == 0) {
                this.elementData = EMPTY_ELEMENTDATA;
            } else {
                throw new IllegalArgumentException("Illegal Capacity: "+
                                                   initialCapacity);
            }
        }
    */

    // add, 扩容
    //! 1. 计算 minCap: add后的新size / 无参构造首次设为10
    /*
        public boolean add(E e) {
            // 加入元素后，需要满足 cap > 新size（元素个数）
            // minCap=新size
            // b 0+1 | c 5+1
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
                // 有参构造，初始化后数组非空，不会进入这里
            }
            return minCapacity;
            // minCap=新size
            // b 1 | c 6
        }*/

        //! 2. 不足则扩容
        /*
        private void ensureExplicitCapacity(int minCapacity) {
            modCount++;
            // overflow-conscious code

            if (minCapacity - elementData.length > 0)
                grow(minCapacity);
            // c数组长度不足minCap，扩容
            // b不用扩容，到此结束
        }*/

        //! 3. 扩容 newCap = max(minCap, 1.5*oldCap)
        /*
        private void grow(int minCapacity) { // c 6
            // overflow-conscious code

            // oldCap c 5
            int oldCapacity = elementData.length;

            // newCap = 1.5*oldCap
            // c 7
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            // newCap = max(minCap, newCap)
            // c max(6, 7) = 7
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
