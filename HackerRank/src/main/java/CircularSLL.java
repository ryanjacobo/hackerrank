public class CircularSLL {
    // CircularSLL doesn't use a head property
    private ListNode last;
    private int length;
    private class ListNode {
        private int data;
        private ListNode next; // Reference to next ListNode in list

        public ListNode(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        int count = 0;
        if(isEmpty()){
            return count;
        }

        ListNode current = last;
        do {
            current = current.next;
            count++;
        }
        while(current != last);
        return count;
    }

    public void createCLL() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
//        fourth.next = second; // skips the first node

        last = fourth;
    }

    public void displayCLL(){
        if(last == null){
            System.out.println("List is null");
            return;
        }
        ListNode first = last.next;
        while(first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data + " --> repeat ");
    }

    public void insertStart(int node){
        ListNode temp = new ListNode(node);
        if(isEmpty()){
            last = temp; // if list is null, last node will be temp
        } else {
            temp.next = last.next; // temp.next points to the node that last.next points to
        }
        last.next = temp; // loops back to temp (start node) i.e. last.next -> temp
        length++;
    }

    public void insertEnd(int node){
        ListNode temp = new ListNode(node);
        if(isEmpty()){
            last = temp; // last becomes the temp (new node)
            last.next = last; // last.next (->) points to last to create the loop
        } else {
            temp.next = last.next; // temp.next(->) points to the node last.next(->) points to
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public ListNode removeFirstNode(){
        if(isEmpty()){
            System.out.println("CLL is empty.");
            return null;
        }

        ListNode remove = last.next; // remove becomes what last.next(->) points to i.e. the first node
//        last.next = remove.next;
//        length--;
//        return remove.next;

        if(last.next == last){
            last = null; // if list has only 1 node, last becomes null
        } else {
            last.next = remove.next; // last.next (->) points to what remove.next (->) points to
        }
        remove.next = null; // remove.next(->) points to null
        length--;
        return remove;
    }

    public static void main(String[] args) {
        CircularSLL cll = new CircularSLL();
        cll.createCLL();
        cll.displayCLL();

        System.out.println("----Insert node at start----");
        cll.insertStart(2);
        cll.insertStart(3);
        cll.displayCLL();

        CircularSLL cll2 = new CircularSLL();
        System.out.println(cll2.isEmpty());
        cll2.insertStart(11);
        cll2.displayCLL();
        System.out.println("CLL length: " + cll2.length());
        cll2.insertStart(12);
        cll2.displayCLL();
        System.out.println("CLL length: " + cll2.length());

        cll2.insertEnd(13);
        cll2.displayCLL();
        System.out.println(cll2.length());

        cll2.insertStart(10);
        cll2.displayCLL();

        System.out.println("----Remove first node----");
        System.out.println("CLL length: " + cll2.length());
        cll2.displayCLL();

        cll2.removeFirstNode();
        System.out.println("CLL length: " + cll2.length());
        cll2.displayCLL();

        cll2.removeFirstNode();
        System.out.println("CLL length: " + cll2.length());
        cll2.displayCLL();

        cll2.removeFirstNode();
        System.out.println("CLL length: " + cll2.length());
        cll2.displayCLL();

        cll2.removeFirstNode();
        System.out.println("CLL length: " + cll2.length());
        cll2.displayCLL();
    }
}
