import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SinglyLinkedList {
    private ListNode head;

    public int length() {

        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Length of the List is " + count + ".");
        return count;
    }

    private static class ListNode {
        private int data; // Can be a generic type
        private ListNode next; // Reference to next ListNode in list

        public ListNode(int data) {
            this.data = data;
            this.next = null; // not necessary
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void displayReverse(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void insertFirst(int value) {
        System.out.println("Insert " + value + " at the beginning of the list.");
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insert(int position, int value) {
        System.out.println("Insert " + value + " in position " + position +".");
        // 1 -> 4 -> 5
        // 1 -> 6 -> 4 -> 5
        ListNode node = new ListNode(value);

        // to follow programming index (starts at 0), change 1 to 0.
        if (position == 1) {
            node.next = head; // head becomes the node.next
            head = node; // node takes the place of head
        } else {
            ListNode previous = head; // head moves to previous
            int count = 1; // counts to position - 1

            while (count < position - 1) {
                previous = previous.next; // previous(head) moves to next
                count++;
            }

            ListNode current = previous.next; // assign previous.next to a temp var
            previous.next = node; // previous.next var takes node
            node.next = current; // node.next becomes current (previous.next > node.next > current)
        }

    }

    public void insertLast(int value) {
        System.out.println("Insert " + value + " at the end of the list.");
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp; // temp returns null therefore the new list doesn't show the former first ListNode anymore
    }

    public void delete(int position) {
        System.out.println("Delete node " + position);
        // if position is valid and starting from 1
        // 3 -> 4 -> 7 -> 8 -> 9 -> null
        if (position == 1) {
            head = head.next; // just move head to head.next to discard the first node of the list
        } else {
            ListNode previous = head;
            int count = 1;
            // position - 1 is the node that's before the node to be deleted
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next; // store previous.next (target node) to current
            previous.next = current.next; // make previous.next the current.next to drop current node
        }
    }

    public ListNode deleteLast() {
        // If list is blank
//        if (head == null || head.next == null) {
            if (head == null) {
//            return head;
            return null;
        }

        // If there's only 1 element in the list
        if (head.next == null) {
            ListNode temp = head;
            head = head.next;
            return temp;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null; // break the chain
        return current;
    }

    // return true or false if node is found in the list
    public boolean find(int searchKey) {
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        // previous -> current -> next -> null
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous; // current.next (->) becomes null on the first loop, then points to previous on the succeeding loops
            previous = current; // previous becomes the head on the first loop, then trails next as next moves to current.next
            current = next;
        }
        return previous;
    }

    public ListNode getMiddleNode() {
        if (head == null) {
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // must be both fastPtr and fastPtr to handle even number of nodes
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }

        // n should always be greater than 0
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }

        ListNode mainPtr = head; // will point to the Nth node from the end
        ListNode refPtr = head; // will tell the mainPtr when to move to find the Nth node

        int count = 0;

        // make the refPtr move n nodes away from mainPtr
        while (count < n) {
            // n cannot be greater than number of nodes
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }

        // make refPtr and mainPtr move synchronously til refPtr gets to null, the node where mainPtr stops is the Nth node from the end
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeNthfromEnd(int n){
//        ListNode removeNode = getNthNodeFromEnd(n);
//        System.out.println("remove node: " + removeNode.data);
//        return removeNode;

        System.out.println("Remove node " + n + " from last node.");
        //previous -> 1 -> 2 -> 3 -> 4 -> null, n = 2
        ListNode refNode = head;
        int count = 0;

        while(count < n) {
            refNode = refNode.next;
            count++;
        }

        ListNode previous = new ListNode(0);
        previous.next = head;
        while(refNode != null){
                refNode = refNode.next;
                previous = previous.next;
            }

            ListNode remove = previous.next;
            previous.next = remove.next; // make previous.next(->) point to remove.next node
    }
    public void removeDuplicatesSorted(){
        if(head == null) {
            return;
        }
        ListNode current = head;
        // current is the first node, current.next is the duplicate node
//        while(current != null && current.next != null){
            while(current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

//        if (head == null) {
//            return newNode;
//        }

        ListNode current = head;
        ListNode temp = null;

        // to find where the newNode is gonna be in between of 2 nodes
//        while (current != null && current.data < newNode.data) {
            while (current != null && current.data < newNode.data) {
            temp = current; // temp trails/follows current
            current = current.next; // current moves to current.next
        }

        temp.next = newNode; // temp.next will pull newNode in front of it
        newNode.next = current; // newNode will be behind current
        return head;
    }

    public void deleteNode(int key) {
        System.out.println(key + " deleted");
        ListNode current = head;
        ListNode temp = null;

        // if key == head, just move head to current.next
//        if (current != null && current.data == key) {
            if (current.data == key) {
            head = current.next;
            return;
        }

//        while (current != null && current.data != key) {
            while (current.data != key) {
            temp = current;
            current = current.next;
        }

        // if current (key) is null
//        if (current == null) {
//            return;
//        }

        temp.next = current.next;
    }

    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        // check to make sure fastPtr hasn't reached null, if it does then list has a loop
        while (fastPtr != null && fastPtr.next != null) {
//            while (fastPtr.next != null) {
            fastPtr = fastPtr.next.next; // fastPtr travels 2x faster than slwPtr
            slowPtr = slowPtr.next;

            // if slow fastPtr comes around to slowPtr, list contains a loop
            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    // determine whether or not there's a loop first then find the start node of the loop
    // Floyd's cycle detection algorithm
    // fastPtr x 2(2x of slowPtr) = tail + (length of loop X number of rotations) + diameter of loop
    // slowPtr = tail + (length of loop X number of rotations) + diameter of loop
    // meeting node: X = n x (Cf - Cs) => simplified fastPtr - slowPtr
    public ListNode getStartingNode() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
//            while (fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    // Helper method of startNodeInALoop(), slowPtr is what was used to determine whether or not there's a loop
    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;

        // when temp and slowPtr lands at the same node, that node is the start node of the loop
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp; // starting node of the loop
    }

    public void removeLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

//        while (fastPtr != null && fastPtr.next != null) {
            while (fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

//    slowPtr is what was used to determine whether or not there's a loop
    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;

        // loop while temp.next and slowPtr.next are not the same
        while (temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        // when slowPtr.next and temp.next are the same, make slowPtr.next point to null (instead of node third to break the loop)
        slowPtr.next = null;
    }

    public void createALoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
//        third.next = first;
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third; // loop starting node is 3
    }

//    merge 2 sorted linked lists
    public static ListNode merge(ListNode a, ListNode b) {
        // a --> 1 --> 3 --> 5 --> null
        // b --> 2 --> 4 --> 6 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null

        // return head instead of dummy.next
//        ListNode head = null;
//        if(a.data <= b.data){
//            head = a;
//            a = a.next;
//        } else {
//            head = b;
//            b = b.next;
//        };

        ListNode dummy = new ListNode(0); // initial head should not be null so it can serve as the head
        ListNode tail = dummy;

        // while neither one of the list is not exhausted
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next; // move the tail forward
        }

        // a --> 1 --> 3 --> null
        // b --> 2 --> 4 --> 6 --> 7 --> 9 --> 10 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 6 --> 7 --> 9 --> 10 --> null

        // add the remaining nodes after either one of the list is exhausted
        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next; // dummy.next will be the head of the list (not dummy(0))
    }

    // merge k sorted linked lists
    public static ListNode mergeKLists(ListNode[] lists){
        // lists = [[1,4,5],[1,3,4],[2,6]]
        // dummy.next = 1,1,2,3,4,4,5,6
        //create a heap that will store the starting node of each list in ascending order
        //move each node to the list by ascending order as well

        Queue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.data-b.data);

        // loop through each list in lists using for-loop
//        for(ListNode list : lists){
//            if(list == null) continue;
//            minHeap.add(list); // add each list to the minHeap
//        }

        // using while-loop
        int i = 0;
        while(i < lists.length){
            if(lists[i] == null) continue;
            minHeap.add(lists[i]); // add each list to the minHeap
            i++;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(!minHeap.isEmpty()){
            ListNode top = minHeap.poll();
            cur.next = top;
            cur = cur.next;
            if(top.next != null){
                minHeap.add(top.next);
            }
        }
        return dummy.next;
    }
    // add 2 singly linked list
    public static ListNode addLinkedLists(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(a != null || b != null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(1);
        sll1.insertLast(2);
        sll1.insertLast(3);
        sll1.display();

        ListNode reverseHead = sll1.reverse(sll1.head);
        System.out.print("Reversed: ");
        sll1.displayReverse(reverseHead);

//        SinglyLinkedList sll2 = new SinglyLinkedList();
//        sll2.insertLast(3);
//        sll2.insertLast(5);
//        sll2.insertLast(8);
//        sll2.insertLast(9);
//        sll2.insertLast(14);
//        sll2.insertLast(18);
//
//        sll1.display();
//        sll2.display();
//
//        SinglyLinkedList result = new SinglyLinkedList();
//        result.head = merge(sll1.head, sll2.head);
//
//        result.display();

        SinglyLinkedList sll = new SinglyLinkedList();
        ListNode first = new ListNode(11);
        ListNode second = new ListNode(12);
        ListNode third = new ListNode(13);
        ListNode fourth = new ListNode(14);

        sll.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        System.out.print("New list: ");
        sll.display();

        System.out.println(sll.length());

        sll.insertFirst(2);
        sll.display();

        sll.insertLast(7);
        sll.display();
        sll.insert(1, 5);
        sll.display();
        sll.insert(1, 13);
        sll.display();

        System.out.println("Delete first element: " + sll.deleteFirst().data);
        sll.display();

        System.out.println("Delete last element: " + sll.deleteLast().data);
        sll.display();

        SinglyLinkedList sllBlank = new SinglyLinkedList();
        System.out.println("Delete last element: " + sllBlank.deleteLast());
        sllBlank.display();

        sllBlank.head = new ListNode(1);
        System.out.println("Delete last element: " + sllBlank.deleteLast().data);
        sllBlank.display();

        System.out.println("----Delete specified node----");
        sll.delete(2);
        sll.display();

        int searchKey = 2;
        System.out.println("Found " + searchKey + "? " + sll.find(searchKey));

        System.out.println("----Find middle node----");
        sll.display();
        ListNode middleNode = sll.getMiddleNode();
        System.out.println("Middle node is " + middleNode.data);

        System.out.println("----Get nth Node from the end---");
        int nthNode = 2;
        System.out.println(nthNode + " node from the end is " + sll.getNthNodeFromEnd(nthNode).data);
//        sll.delete(4);
        sll.display();
        sll.removeNthfromEnd(2);
        sll.display();

        System.out.println("----Remove duplicate nodes from a sorted list----");
        sll.insertFirst(5);
        sll.display();
        sll.insertLast(10);
        sll.insertLast(8);
        sll.removeDuplicatesSorted();
        sll.display();

        System.out.println("----Insert new node in a sorted Singly linked list----");
        SinglyLinkedList sortedSll = new SinglyLinkedList();
        sortedSll.head = new ListNode(1);
        ListNode sorted2 = new ListNode(5);
        sortedSll.head.next = sorted2;
        sortedSll.display();
        sortedSll.insertInSortedList(2);
        sortedSll.insertInSortedList(3);
        sortedSll.insertInSortedList(4);
        sortedSll.display();

        System.out.println("----Insert new node in specified position of the list----");
        sll.insert(2, 2);
        sll.display();

        System.out.println("----Delete specified node----");
        sll.deleteNode(5);
        sll.display();
//        sll.deleteNode(5);
//        sll.display();
//        sll.deleteNode(10);
//        sll.display();
//        sll.deleteNode(1);
//        sll.display();
//        sll.deleteNode(8);
//        sll.display();

        System.out.println("----List contains loop----");
        System.out.println(sll.containsLoop());
        SinglyLinkedList loopedList = new SinglyLinkedList();
        loopedList.createALoopInLinkedList();
        System.out.println(loopedList.containsLoop());

        System.out.println("Starting loop node: " + loopedList.getStartingNode().data);
        loopedList.removeLoop();
        System.out.print("Loop removed: ");
        loopedList.display();

        System.out.println("----Merge node list----");
        SinglyLinkedList mergedList = new SinglyLinkedList();
        mergedList.head = merge(sll.head,loopedList.head);
        mergedList.display();

        System.out.println("-----Merge k lists----");
//        listA = [1,4,5]; listB = [1,3,4]; listC = [2,6]
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        SinglyLinkedList sllA = new SinglyLinkedList();
        sllA.head = a1;
        sllA.display();

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        SinglyLinkedList sllB = new SinglyLinkedList();
        sllB.head = b1;
        sllB.display();

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;
        SinglyLinkedList sllC = new SinglyLinkedList();
        sllC.head = c1;
        sllC.display();

        ListNode d1 = new ListNode(5);
        ListNode d2 = new ListNode(7);
        ListNode d3 = new ListNode(8);
        d1.next = d2;
        d2.next = d3;
        SinglyLinkedList sllD = new SinglyLinkedList();
        sllD.head = d1;
        sllD.display();

        ListNode[] list = {a1, b1, c1, d1};
        SinglyLinkedList mergedKL = new SinglyLinkedList();
        mergedKL.head = mergeKLists(list);
        mergedKL.display();

        System.out.println("----Add 2 node list----");
        System.out.print("node list a: ");
        sll.display();
        System.out.print("node list b: ");
        loopedList.display();
        SinglyLinkedList sumLinkedList = new SinglyLinkedList();
        sumLinkedList.head = addLinkedLists(sll.head, loopedList.head);
        System.out.print("node lists sum: ");
        sumLinkedList.display();


        System.out.println("----Reverse the Node----");
        sll.display();
        ListNode reverseSll = sll.reverse(sll.head);
        sll.displayReverse(reverseSll);
    }
}
