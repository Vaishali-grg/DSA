package queue;

public class LC0641_DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1)); 
        System.out.println(circularDeque.insertLast(2)); 
        System.out.println(circularDeque.insertFront(3)); 
        System.out.println(circularDeque.insertFront(4)); 
        System.out.println(circularDeque.getRear());     
        System.out.println(circularDeque.isFull());       
        System.out.println(circularDeque.deleteLast());  
        System.out.println(circularDeque.insertFront(4)); 
        System.out.println(circularDeque.getFront());   
    }
}

class MyCircularDeque {
    private int[] arr;
    private int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        arr = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        if (size == 0) {
            rear = front;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (size > 0) {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            rear = front;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}