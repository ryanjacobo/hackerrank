import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueLesson{
    public static class Customer implements Comparable<Customer>{
        // Comparable<> interface is required for PriorityQueue to work. Compares objects by orderId.
        private Integer orderId;
        private Double amount;
        public String customerName;

        public Customer(Integer orderId, Double amount, String customerName) {
            this.orderId = orderId;
            this.amount = amount;
            this.customerName = customerName;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "orderId=" + orderId +
                    ", amount=" + amount +
                    ", customerName='" + customerName + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Customer o) {
//            return 0;
            System.out.println("o.orderId: " + o.orderId);
            return o.orderId > this.orderId ? 1 : -1;

        }
    }

    public static class CustomerOrder implements Comparator<Customer>{
        // Compares objects by amount.
        @Override
        public int compare(Customer o1, Customer o2){
            return o1.getAmount() < o2.getAmount() ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue is FIFO (First In First Out)
//        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // arrange elements in reverse order
        pq.add(3);
        pq.add(4);
        pq.add(2);
        pq.add(1);
        pq.add(14);
        pq.add(21);
        pq.add(11);
        pq.add(31);

        // Arranged in the order of min heap. Min heap is a binary tree with parent root as the min element and leafs increase from left to right.
        System.out.println("priority queue content: " + pq);
        System.out.println("head of the queue: " + pq.peek()); // shows the head of the array
//        System.out.println("head removed: " + pq.poll()); // poll removes the first element and re-arranges the array by min heap
//        System.out.println("priority queue content: " + pq);

        Iterator<Integer> iterator = pq.iterator();
        while(iterator.hasNext()){
            System.out.println(pq.poll()); // sorts and prints the elements
        }

        Queue<Customer> customers = new PriorityQueue<>(new CustomerOrder());
        customers.add(new Customer(6, 50.0, "Shabbir"));
        customers.add(new Customer(1, 100.0, "Nikhil"));
        customers.add(new Customer(4, 500.0, "Shivam"));

        System.out.println(customers);
        System.out.println(customers.peek());
        System.out.println(customers.poll());
        System.out.println(customers.poll());
    }
}
