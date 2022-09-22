package _1_2_list;

class CircularList {
    static class Node{
        int data;
        Node next;
        Node prior;

        Node(){
            next = prior = null;
        }

        Node(int data){
            this();
            this.data = data;
        }
    }

    Node rear;
    int length;

    CircularList(){
        length = 0;
        rear = null;
    }

    private Node getNode(int index){
        if (rear == null || index < 0 || index > length - 1)
            return null;
        Node node = rear.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    void insert(int data){
        insert(length, data); // insert to the tail
    }

    void insert(int index, int data){
        // err input [0..len]
        if (index < 0 || index > length)
            return;
        Node node = new Node(data);
        // special case (null list, insert to last)
        if (length == 0){
            rear = node;
            rear.next = rear.prior = rear;
            length++;
            return;
        }
        // get prior of the position to be inserted
        Node prior;
        if (length != index){
            prior = getNode(index).prior;
        } else {
            prior = rear;
            rear = node;
        }
        // insert
        node.prior = prior;
        node.next = prior.next;
        node.prior.next = node;
        node.next.prior = node;
        // update length
        length++;
    }

    int remove(int index){
       if (index < 0 || index > length - 1)
           return -1;
        Node node = getNode(index);
        int ret = node.data;
        // remove
        if (length != 1) {
            node.next.prior = node.prior;
            node.prior.next = node.next;
            // update rear
            if (length - 1 == index) {
                rear = node.prior;
            }
        }else {
            rear = null;
        }
        // update len
        length--;
        node = null;
        return ret;
    }

    void append(CircularList tail){
        if (length == 0){
            rear = tail.rear;
            length = tail.length;
            return;
        }
        if (tail.length == 0)
            return;
        Node head = rear.next;
        // change ptr
        head.prior = tail.rear;
        rear.next = tail.rear.next;
        tail.rear.next.prior = rear;
        tail.rear.next = head;
        // update len, rear ?
        rear = tail.rear;
        length += tail.length;
    }

    // swap node at index with next
    void swap(int index){
        // err input
        if(index < 0 || index > length - 1)
            return;
        if (length == 2){
            rear = getNode(0);
            return;
        }
        Node node = getNode(index);
        Node next = node.next;
        node.next = next.next;
        next.prior = node.prior;
        node.prior = next;
        next.next = node;
        node.next.prior = node;
        next.prior.next = next;
        // tail
        if (index == length - 1){
            rear = next;
        } else if (index == length - 2)
            rear = node;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node node = rear;
        if (node != null)
        do {
            node = node.next;
            sb.append(node.data + " ");
        }while (node != rear);
        sb.append("len: " + length);
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularList list1 = new CircularList();
        // n-n, 0-n, n-0, 1-0, 0-1, 1-1, 0-0
        list1.insert(0);
        list1.insert(2);
        list1.insert(3);
        list1.insert(1, 1);
        list1.remove(0);
        System.out.println(list1.toString());
//        list1.swap(0);
//                list1.swap(1);
//        list1.swap(2);
//        System.out.println(list1.toString());


//        var list2 = new CircularList();
//        list2.insert(4);
//        list2.insert(5);
//        list2.insert(6);
//        System.out.println(list2.toString());
        //        list1.append(list2);
        //        System.out.println(list1.toString());
    }
}
