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
//            System.out.println("List is not circular.");
            return;
        }
        ListNode first = last.next;
        while(first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.print(first.data + " --> repeat ");
    }

    public static void main(String[] args) {
        CircularSLL cll = new CircularSLL();
        cll.createCLL();
        cll.displayCLL();
    }
}
