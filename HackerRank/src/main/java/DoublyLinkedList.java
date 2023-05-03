//import java.util.List;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    // DoublyLinkedList properties
    private ListNode head;
    private ListNode tail;
    private int length;

    // DoublyLinkedList Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    private static class ListNode {
        // ListNode properties
        private int data;
        private ListNode next;
        private ListNode previous;

        // ListNode constructor
        public ListNode(int data) {
            this.data = data;
        }
    }


    public boolean isEmpty() {
        return length == 0;
    }

    public int length(){
        System.out.println("length: " + length);
        return length;
    }

    public void displayForward() {
        System.out.print("Print list forward: ");
//        if(head == null){
            if(isEmpty()){
            return;
        }

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        System.out.print("Print list backward: ");
//        if(tail == null){
            if(isEmpty()){
            return;
        }

        ListNode temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        System.out.println("insert at the beginning: " + value);
        System.out.println("is list empty: " + isEmpty());
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
            tail = newNode; // newNode becomes the tail
        } else {
            head.previous = newNode; // if list is not empty, head.previous becomes newNode
        }
        // push the list forward (to accommodate newNode)
        newNode.next = head;
        // head becomes the newNode
        head = newNode;
        length++;
    }

    public void insertLast(int value) {
        System.out.println("insert at end: " + value);
        System.out.println("is list empty: " + isEmpty());
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode; // if list is not empty, newNode goes to tail.next
        }
        newNode.previous = tail; // newNode.previous becomes the old tail
        tail = newNode; // the tail becomes the newNode
        length++;
    }

    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head; // what will be removed
        if(head == tail){
            tail = null;
        } else {
            head.next.previous = null; // removes the previous link (<-)
        }
        head = head.next; // moves head to the next node
        temp.next = null; // removes the next link (->)
        length--;
        return temp;
    }

    public ListNode deleteEnd(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        } else {
            tail.previous.next = null; // removes the next link (->) to the tail
        }
        tail = tail.previous; // tail moves to tail.previous node
        temp.previous = null; // removes temp.previous link (<-)
        length--;
        return temp;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);

        dll.head = first;
        first.next = second;
        dll.displayForward();

        dll.insertLast(3);
        dll.displayForward();
        dll.length();
        dll.insertLast(4);
        dll.displayForward();
        dll.length();

        dll.displayBackward();

        dll.insertFirst(5);
        dll.displayForward();
        dll.displayBackward();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.insertFirst(1);
        dll2.displayForward();

        System.out.println("delete first node: " + dll.deleteFirst().data);
        dll.displayForward();

        System.out.println("delete last node: " + dll.deleteEnd().data);
        dll.displayForward();
    }
}
