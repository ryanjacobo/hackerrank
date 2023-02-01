package Lists;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueLesson {
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayBlockingQueue<>(3);
//        System.out.println("Head of the queue: " + q1.element()); // Throws NoSuchElementException

        q1.add(10);
        q1.add(20);
        q1.add(30);

        System.out.println("Head of the queue: " + q1.element());

        try {
            q1.add(40);
        } catch (IllegalStateException e) {
            System.out.println("Exceeded specified capacity.");
        }

        for(Integer value: q1) {
            System.out.println(("Queue value: " + value));
        }

//        Integer value = q1.remove();
        System.out.println("Removed from queue: " + q1.remove());
        System.out.println("Removed from queue: " + q1.remove());
        System.out.println("Removed from queue: " + q1.remove());

        try {
            System.out.println("Removed from queue: " + q1.remove());
        } catch (NoSuchElementException e){
            System.out.println("Queue is empty.");
        }

        Queue<Integer> q2 = new ArrayBlockingQueue<>(2);
        System.out.println("Queue2 peek: " + q2.peek());
        q2.offer(10);
        q2.offer(20);
        q2.offer(30);

        if(q2.offer(40) == false) {
            System.out.println("Failed to add item. Queue's capacity is only 2.");
        }

        for(Integer value: q2) {
            System.out.println("Queue value: " + value);
        }

        System.out.println("Queue2 poll: " + q2.poll());
        System.out.println("Queue2 poll: " + q2.poll());
        System.out.println("Queue2 poll: " + q2.poll());
    }
}
