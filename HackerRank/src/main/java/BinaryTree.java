import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    // inner class
    public class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;

        // 1
        // 2
        // 4 5
        // 3
        // 6 7
        // etc...
    }

    // Pre-order binary Tree traversal (Print the binary tree) - visit the root node, traverse the left subtree, traverse the right subtree
    // Recursive - calls itself with the method
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left); // loops til root.left is null
        preOrder(root.right);
    }

    // Iterative - uses a loop
    public void preOrderIterative(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrder(bt.root);
        System.out.println();
        System.out.println("---preOrder Stack---");
        bt.preOrderIterative(bt.root);
    }
}
