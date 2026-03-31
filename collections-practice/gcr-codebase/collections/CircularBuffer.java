package collections;

public class CircularBuffer {

    private int[] buffer;
    private int size;
    private int front;
    private int count;
    CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        count = 0;
    }
    void insert(int value) {

        int rear = (front + count) % size;

        buffer[rear] = value;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size;
        }
    }
    void display() {

        System.out.print("Buffer: [ ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();
        cb.insert(4); 
        cb.display();
    }
}
