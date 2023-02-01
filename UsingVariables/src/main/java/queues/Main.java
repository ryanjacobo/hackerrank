package queues;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);

        try{
            q1.add(10);
            q1.add(20);
            q1.add(30);
//            q1.add(40);
        }catch(IllegalStateException e){
            System.out.println("Queue if full.");

        }
        System.out.println(q1);
//        System.out.println(q1.remove());
       try{
           System.out.println("Removed " + q1.remove() + " from q1.");
       } catch (NoSuchElementException e){
           System.out.println("No more items to remove from queue.");
       }
        System.out.println(q1);

       Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);

       // .offer allows to add all elements within capacity
       q2.offer(10);
        q2.offer(20);
        q2.offer(30);

        int i = 0;
        if(q2.offer(30) == false){
            System.out.println("Offer 30 was not added.");
        }
        for(Integer value: q2){
            System.out.println("Q2 element " + i + ": " + value);
        }

        System.out.println(q2.poll());
        System.out.println(q2);

        System.out.println(q2.peek());
    }
}
