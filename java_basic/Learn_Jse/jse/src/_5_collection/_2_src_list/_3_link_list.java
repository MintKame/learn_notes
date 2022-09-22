package _5_collection._2_src_list;

import java.util.LinkedList;

public class _3_link_list {
    public static void main(String[] args) {
        /*
            LinkedList属性：首尾节点 => 双端队列
                transient LinkedList.Node<E> first;
                transient LinkedList.Node<E> last;

            Node属性：前后节点 => 双向链表
                E item;
                Node<E> next;
                Node<E> prev;
        */
        LinkedList list = new LinkedList();
        list.add(1); // a 空list
        list.add(2); // b 非空list
        list.add(3);

        // list.remove(); // 删第一个节点
        list.remove(Integer.valueOf(2)); // c 有前后节点
        list.remove(Integer.valueOf(3)); // d 有前节点
        list.remove(Integer.valueOf(1)); // e 无前后节点

        // public LinkedList() {}
        // first = null, last = null

        /* add
            public boolean add(E e) {
                linkLast(e);
                return true;
            }

            // 新节点加到末尾
            void linkLast(E e) {
                final Node<E> l = last; // last: a null | b Node(1)
                final Node<E> newNode = new Node<>(l, e, null);
                last = newNode; // 新节点作为最后一个，更新last指针
                if (l == null)
                    first = newNode; // a 更新first指针
                else
                    l.next = newNode; // b 更新前一个节点的next
                size++;
                modCount++;
            }
        */

        /* remove
            public E remove(int index) {
                checkElementIndex(index);
                return unlink(node(index));
            }

            E unlink(Node<E> x) {
                // assert x != null;
                final E element = x.item;
                final Node<E> next = x.next;
                final Node<E> prev = x.prev;

                // 更新：
                // linkList的首尾节点
                // 被删节点和其前后节点的前后指针
                if (prev == null) {
                    first = next;
                } else {
                    prev.next = next;
                    x.prev = null;
                }

                if (next == null) {
                    last = prev;
                } else {
                    next.prev = prev;
                    x.next = null;
                }

                x.item = null; // 节点的数据设置为null
                size--;
                modCount++;
                return element; // 返回节点的数据
            }
        */
    }
}
