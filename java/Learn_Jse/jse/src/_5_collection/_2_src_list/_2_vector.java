package _5_collection._2_src_list;

import java.util.Vector;

public class _2_vector {
    // vector 内部维护数组
    // protected Object[] elementData;

    public static void main(String[] args) {
        // 无参构造：10 -> *2
        // 有参构造：x -> *2
        Vector vector = new Vector(); // a size/cap = 0/10

        vector.add(1); // b 1/10

        for (int i = 2; i <= 10; i++) {
            vector.add(i);
        }// 10/10

        vector.add(11); // c 11/20

        /* ctor a
            public Vector() {
                this(10);
            }
        */
        //! 1. 计算 minCap（add后新size）, 不足则扩容
        /*
            public synchronized boolean add(E e) {
                modCount++;
                // minCap > 新size
                // b 1 | c 11
                ensureCapacityHelper(elementCount + 1);
                elementData[elementCount++] = e;
                return true;
            }

            private void ensureCapacityHelper(int minCapacity) {
                // overflow-conscious code
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
                // b 不用扩容，到此结束
                // c 数组长度不足minCap，扩容
            }*/

        //! 2. 扩容 newCap = max(minCap, 2*oldCap)
        /*
            private void grow(int minCapacity) { // 11
                // overflow-conscious code

                // oldCap c 10
                // newCap = oldCap*2 = 20
                int oldCapacity = elementData.length;
                int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                                 capacityIncrement : oldCapacity);

                // max(minCap, newCap) c max(11, 20)=20
                if (newCapacity - minCapacity < 0)
                    newCapacity = minCapacity;

                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
         */
    }
}
