package collections;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    void push(int x) {
        q1.add(x);
    }
    int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int poppedElement = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }
    int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int topElement = q1.remove();
        q2.add(topElement);
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topElement;
    }
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top()); 
    }
}
