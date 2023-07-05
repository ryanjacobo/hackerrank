public class CompleteBinaryTree {
    static Integer[] heap;
    static int n;
    public static void MaxPQ(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    public static void main(String[] args) {
        CompleteBinaryTree pq = new CompleteBinaryTree();
        pq.MaxPQ(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
    }
}
