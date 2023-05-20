import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueList {
    private QueueNode front;
    private QueueNode rear;
    private int length;

    private class QueueNode {
        private int data;
        private QueueNode next;

        public QueueNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void print() {
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode current = front;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(int data){
        QueueNode temp = new QueueNode(data);
        if(isEmpty()){
            front = temp; // front is gonna be the left most element of the queue
        } else {
            rear.next = temp; // rear -> temp, -> = rear.next
        }
        rear = temp; // rear becomes temp
        length++;
    }

    // remove the first node
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Nothing to dequeue.");
            return;
        }
        front = front.next;
        // if queue is down to 1 element, front and rear should be pointing to null
        if(front == null){
            rear = null;
        }
        length--;
    }

    public int first() {
        System.out.println("First node: " + front.data);
        return front.data;
    }

    public Object last() {
        System.out.println("last node: " + rear.data);
        return rear.data;
    }

    // Generate a binary tree
    // order is left to right i.e. n=6 -> 1(1), 01(2), 11(3), 100(4), 101(5), 110(6)
    public static String[] generateBinaryNumbers(int n) {
        String[] result = new String[n]; // what will hold the String[] binary numbers
        Queue<String> q = new LinkedList<>(); // what will hold the individual binaries
        q.offer("1"); // head of the binary tree, offer means add a new element to the Queue
        for(int i = 0; i < n; i++){
            result[i] = q.poll(); // assign each element of result String[]
            String n1 = result[i] + "0"; // append 0 to result[i]
            String n2 = result[i] + "1"; // append 1 to result[i]
            q.offer(n1); // add n1 to Queue
            q.offer(n2); // add n2 to Queue
        }
        return result;
    }


    public static void main(String[] args) {
        QueueList qL = new QueueList();
        qL.print();
        qL.enqueue(1);
        qL.enqueue(2);
        qL.enqueue(3);
        qL.enqueue(4);
        qL.print();
        qL.first();
        qL.last();
        qL.dequeue(); // dequeue 1
        qL.dequeue(); // dequeue 2
        qL.dequeue(); // dequeue 3
        qL.first();
        qL.last();
        qL.print();
        qL.dequeue(); // dequeue 4
//        qL.first();
//        qL.last();
        qL.print();
        qL.dequeue();

        int n1 = 4;
        System.out.println(Arrays.toString(generateBinaryNumbers(n1)));
        int n2 = 8;
        System.out.println(Arrays.toString(generateBinaryNumbers(n2)));
    }
}
