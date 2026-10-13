package queue;

public class CircularQueueImplementation {
    static class CircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        void enqueue(int value) {
            if (size == capacity) {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
            System.out.println("Inserted " + value);
        }

        void dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("removed " + arr[front]);
            front = (front + 1) % capacity;
            size--;
            if (size == 0) {
                front = 0;
                rear = -1;
            }
        }

        void display() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return;
            }
            System.out.println("Queue");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.print(arr[index] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.display();
        q.dequeue();
        q.display();
    }
}