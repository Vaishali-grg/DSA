package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RunningAverage {
    public static void main(String[] args) {
        // Pass the window size (e.g., 3) to the constructor
        MovingAverage obj = new MovingAverage(3);

        System.out.println(obj.next(1));  // Output: 1.0
        System.out.println(obj.next(5));  // Output: 3.0
        System.out.println(obj.next(10)); // Output: 5.333333333333333
        System.out.println(obj.next(25)); // Output: 13.333333333333334
    }
}

class MovingAverage {
    private Queue<Integer> queue;
    private int maxSize;
    private double sum;

    public MovingAverage(int size) {
        this.maxSize = size;
        this.queue = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {
        // If the queue is at maximum capacity, remove the oldest element and subtract it from the sum
        if (queue.size() == maxSize) {
            sum -= queue.poll();
        }
        
        // Add the new value to the queue and add it to the running sum
        queue.add(val);
        sum += val;
        
        // Return the current average
        return sum / queue.size();
    }
}