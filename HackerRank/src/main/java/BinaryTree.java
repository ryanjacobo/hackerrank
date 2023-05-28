import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    // inner class
    public class TreeNode{
        int data;
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
        System.out.print(root.data + " "); // prints root.data before calling itself
        preOrder(root.left); // calls itself til root.left is null
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

    // In-order binary tree traversal
    // Recursive
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left); // calls itself til root is null before printing the root.data
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Iterative
    public void inOrderIterative(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    // Post-order - traverse the left subtree in Post-order fashion, traverse the right subtree in Post order fashion, visit the node
    // Recursive
    public void postOrderRecursive(TreeNode root){
        if(root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative
    public void postOrderIterative(TreeNode root){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right; // peek() gets the top element without removing it from the stack
                if(temp == null){
                    temp = stack.pop(); // pop() removes the top element from the stack
                    System.out.print(temp.data + " ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }else {
                    current = temp;
                }
            }
        }
    }

    // Recursive
//    public void levelOrderRecursive(TreeNode root){
//        if(root == null){
//            return;
//        }
//        System.out.print(root.data + " ");
//        levelOrderRecursive(root.left);
//        levelOrderRecursive(root.right);
//    }
    // Iterative
    public void levelOrderIterative(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result)
            result = left;
        if(right > result)
            result = right;
        return result;
    }

    // Binary Search Tree - Left subtree of the node contains less value than the node and right subtree of the new contains higher value than the node
    public void insertRoot(int value){
        root = insertBS(root, value);
    }
    public TreeNode insertBS(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data) {
            root.left = insertBS(root.left, value);
        } else {
            root.right = insertBS(root.right, value);
        }
        return root;
    }

    public TreeNode searchTN(TreeNode root, int key) {
        if(root == null || root.data == key){
            return root;
        }
        if(key < root.data) {
            return searchTN(root.left,key);
        } else {
            return searchTN(root.right, key);
        }
    }

    public TreeNode search(int key){
        return searchTN(root, key);
    }

    public void treeNodeFound(int key){
//        if(null != search(key)){
            if(null != searchTN(root,key)){
            System.out.println("TreeNode " + key + " found.");
        } else {
            System.out.println("TreeNode " + key + " not found.");
        }
    }

    public void isValid(TreeNode root){
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValidBST(root.left, min, root.data);
        if(left){
            boolean right = isValidBST(root.right, root.data, max);
            return right;
        }
        return false;
    }

    // leetcode 226 - invertTree
    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    // leetcode 104 - find Dept of Binary Tree
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
       int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Leetcode 100 - is same tree?
    public static boolean isSameTree(TreeNode p, TreeNode q){
        // Base case - keeps the method from looping itself
        if(p==null && q==null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }
        else if(p.data != q.data){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        System.out.println("---preOrder traversal---");
        bt.createBinaryTree();
        System.out.print("Recursive: ");
        bt.preOrder(bt.root);
        System.out.println();
        System.out.print("Iterative: ");
        bt.preOrderIterative(bt.root);
        System.out.println();

        System.out.println("---inOrder traversal---");
        System.out.print("Recursive: ");
        bt.inOrder(bt.root);
        System.out.println();
        System.out.print("Iterative: ");
        bt.inOrderIterative(bt.root);
        System.out.println();

        System.out.println("---postOrder traversal---");
        System.out.print("Recursive: ");
        bt.postOrderRecursive(bt.root);
        System.out.println();

        System.out.print("Iterative: ");
        bt.postOrderIterative(bt.root);
        System.out.println();

        System.out.println("---levelOrder traversal---");
        System.out.print("Recursive: ");
//        bt.levelOrderRecursive(bt.root);
        System.out.println("Doesn't work.");

        System.out.print("Iterative: ");
        bt.levelOrderIterative(bt.root);
        System.out.println();

        System.out.println("---Find Max---");
        System.out.print("Max TreeNode: ");
        System.out.println(bt.findMax(bt.root));

        System.out.println("---Binary Search Tree---");
        BinaryTree bt2 = new BinaryTree();
        bt2.insertRoot(5);
        bt2.insertRoot(3);
        bt2.insertRoot(7);
        System.out.print("TreeNode root: ");
//        bt2.levelOrderIterative(bt2.root);
        bt2.inOrder(bt2.root);
        bt2.insertBS(bt2.root, 2);
        bt2.insertBS(bt2.root, 4);
        bt2.insertBS(bt2.root, 6);
        System.out.println();
        System.out.print("TreeNode root: ");
        bt2.levelOrderIterative(bt2.root);
        System.out.println();

        System.out.println("---TreeNode search---");
        System.out.print("Node found: ");
        System.out.println(bt2.searchTN(bt2.root, 6).data);
        bt2.inOrder(bt2.root);
        System.out.println();
        bt2.treeNodeFound(7);
        bt2.treeNodeFound(1);

        System.out.println("---Is BST valid---");
        BinaryTree bt3 = new BinaryTree();
        bt3.insertRoot(6);
        bt3.insertRoot(4);
        bt3.insertRoot(8);
        bt3.insertRoot(2);
        bt3.insertRoot(5);
        bt3.insertRoot(7);
        bt3.insertRoot(9);
        bt3.insertRoot(1);

        bt3.levelOrderIterative(bt3.root);
        System.out.println();
        bt3.isValid(bt3.root);

        System.out.println("---Invert BST---");
        invertTree(bt3.root);
        System.out.print("Inverted BST: ");
        bt3.levelOrderIterative(bt3.root);
        System.out.println();

        System.out.println("---Binary Tree Max Depth---");
        int bTDepth = bt3.maxDepth(bt3.root);
        System.out.print("Binary Tree depth: " + bTDepth);

        System.out.println("---isSameTree---");
        BinaryTree p = new BinaryTree();
        p.insertRoot(1);
        p.insertRoot(2);
        p.insertRoot(3);
        BinaryTree q = new BinaryTree();
        q.insertRoot(1);
        q.insertRoot(2);
        q.insertRoot(3);
        System.out.println(isSameTree(p.root, q.root));
    }
}
