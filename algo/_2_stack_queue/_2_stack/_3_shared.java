package _2_stack_queue._2_stack;

import java.util.Arrays;

class SharedStack{
    public static void main(String[] args) {
        SharedStack stack = new SharedStack(5);
        stack.push(0, 0);
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(1, 3);
        stack.push(1, 4);
        stack.pop(1);
        System.out.println(stack.toString());
    }
    int size;
    int[] arr;
    int top_0, top_1;

    SharedStack(int size){
        this.size = size;
        arr = new int[size];
        top_0 = -1;
        top_1 = size;
    }

    public int top(int stackNum){
        if (stackNum == 0 && top_0 >= 0){
            return arr[top_0];
        }else if (stackNum == 1 && top_1 < size){
            return arr[top_1];
        }else
            return -1;  // empty
    }

    public void pop(int stackNum){
        // not empty
        if (stackNum == 0 && top_0 >= 0){
            arr[top_0--] = -1;  // if data is object, set to null
        }else if (stackNum == 1 && top_1 < size){
            arr[top_1++] = -1;
        }
    }

    public void push(int stackNum, int data){
        // full
        if (top_0 + 1 == top_1)
            return;
        // not full
        if (stackNum == 0){
            arr[++top_0] = data;
        }else if (stackNum == 1){
            arr[--top_1] = data;
        }
    }

    @Override
    public String toString() {
        return "SharedStack{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", top_0=" + top_0 +
                ", top_1=" + top_1 +
                '}';
    }
}
