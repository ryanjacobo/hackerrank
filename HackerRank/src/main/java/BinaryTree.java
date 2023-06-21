import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTree {
//    static TreeNode root;
    TreeNode root;

    // inner class
    public static class TreeNode{
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
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    public void binaryST(){
        TreeNode first = new TreeNode(8);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(9);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(11);
        TreeNode seventh = new TreeNode(4);
        TreeNode eight = new TreeNode(6);
        TreeNode ninth = new TreeNode(10);
        TreeNode tenth = new TreeNode(5);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = null;
        third.right = sixth;
        fourth.left = null;
        fourth.right = null;
        fifth.left = seventh;
        fifth.right = eight;
        sixth.left = ninth;
        seventh.left = null;
        seventh.right =null;
        eight.left = tenth;
    }

    // Pre-order binary Tree traversal - visit the root node, traverse the left subtree in pre-order fashion, traverse the right subtree in pre-order fashion
    // Recursive - calls itself with the method
    public static void preOrderRec(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " "); // visit the root node
        preOrderRec(root.left); // traverse the left subtree (in pre-order fashion)
        preOrderRec(root.right); // traverse the right subtree (in pre-order fashion)
    }

    // Iterative
    public static void preOrderIterative(TreeNode root){
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

    // In-order binary tree traversal - traverse the left subtree (in in-order fashion), visit the root node, traverse the right subtree
    // used for arranging a BST in ascending order
    // Recursive
    public static void inOrderRec(TreeNode root){
        if(root == null){
            return;
        }
        inOrderRec(root.left); // traverse the left subtree till node.left is null
        System.out.print(root.data + " "); // visit the root node
        inOrderRec(root.right);
    }

    // Iterative
    public static void inOrderIterative(TreeNode root){
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
    public static void postOrderRecursive(TreeNode root){
        if(root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // Level-Order - Iterative
    public static void postOrderIterative(TreeNode root){
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

    // Level-order - Recursive
    static List<List<Integer>> result;
    public static void levelOrderRecursive(TreeNode root){
        result = new ArrayList<>();
        if(root == null){
            return;
        }
        traverseLOR(root, 0);
        System.out.println(result);
    }
    public static void traverseLOR(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>()); // add a new list for current level
        }
        result.get(level).add(root.data);
        traverseLOR(root.left, level+1);
        traverseLOR(root.right, level+1);
    }
    // Iterative
    public static void levelOrderIterative(TreeNode root) {
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

    public static int findMax(TreeNode root) {
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
    public void createBST(int value){
        root = addNode(root, value);
    }
    // createBST helper
    public TreeNode addNode(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data) {
            root.left = addNode(root.left, value);
        } else {
            root.right = addNode(root.right, value);
        }
        return root;
    }

    // return specified node
    public static TreeNode searchTN(TreeNode root, int node) {
        if(root == null || root.data == node){
            return root;
        }
        if(node < root.data) {
            return searchTN(root.left,node);
        } else {
            return searchTN(root.right, node);
        }
    }

//    public TreeNode search(int key){
//        return searchTN(root, key);
//    }

    public static void treeNodeFound(TreeNode root, int key){
//        if(null != search(key)){
            if(null != searchTN(root,key)){
            System.out.println("TreeNode " + key + " found.");
        } else {
            System.out.println("TreeNode " + key + " not found.");
        }
    }

    // Leetcode 98
    // BST is valid if left subtree is less that its node and right subtree is more than its node
    public static void isValid(TreeNode root){
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }


    public static boolean isValidBST(TreeNode root, long min, long max){
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

    // leetcode 572 - Subtree of another Tree
    public static boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null) {
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Leetcode 235 - find LCA
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.data < root.data && q.data < root.data){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.data > root.data && q.data > root.data){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    // Leetcode 102 - Iterative Level order traversal
    public static List<List<Integer>> levelOrderIt(TreeNode root){
        List<List<Integer>> result = new ArrayList<>(); // nested array list
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size(); // number nodes in each level e.g. level 0 = 1
            List<Integer> currLevel = new ArrayList<>(); // list of nodes in each level
            while(size-- > 0){
                // postfix decrement (size--) means initial value is evaluated first before it's decremented
                // prefix decrement (--size) means initial value is decremented before it's evaluated
                TreeNode curr = q.poll(); // get a node from the q
                currLevel.add(curr.data); // add the node to the currLevel
                if(curr.left != null) q.offer(curr.left); // add left node to q
                if(curr.right != null) q.offer(curr.right); // add right node to q
            }
            result.add(currLevel);
        }
        return result;
    }

    // Leetcode 102 - Recursive Level order traversal
    public static List<List<Integer>> levelOrderRec(TreeNode root){
        result = new ArrayList<>();
        if(root == null) return result;
        traverse(root, 0);
        return result;
    }

    // Leetcode 102 helper
    private static void traverse(TreeNode node, int level){
        if(node == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.data);
        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }

    // Leetcode 230 - kth smallest node
    public static int kthSmallest(TreeNode root, int k){
        if(k == 0)
            return 0;
        List<Integer> list = new ArrayList<>();
        inOrderKS(root, list);
        return list.get(k-1);
    }

    // Leetcode 230 helper - sorts the binary tree
    private static void inOrderKS(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrderKS(root.left, list);
        list.add(root.data);
        inOrderKS(root.right, list);
    }

    // Leetcode 105 - Construct a Binary Tree from preorder and inorder traversal
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static int preIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[]inorder){
        // solution 1
//        for(int i = 0; i<inorder.length; i++) {
//            hm.put(inorder[i], i);
//        }
//        return build(preorder, inorder, 0, inorder.length-1);

        // solution 2
        return build(preorder, inorder, 0, inorder.length-1, 0);
    }

//    public static TreeNode build(int[] preorder, int[] inorder, int start, int end){
    public static TreeNode build(int[] preOrder, int[] inOrder, int inStart, int inEnd, int preStart){
        // inOrder: Left, Root, Right
        // preOrder: Root, Left, Right

            // solution 1
//            if(start > end) return null;
//        TreeNode root = new TreeNode(preorder[preIndex++]);
//        if(root == null) return null;
//        if(start == end) return root;
//        int index = hm.get(root.data);

        // solution 2

        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]); // root of the BT will be the first element of preOrder array
        int index = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(root.data == inOrder[i]){
                index = i;
            }
        }
        root.left = build(preOrder, inOrder, inStart, index-1, preStart+1);
        root.right = build(preOrder, inOrder, index + 1, inEnd, preStart + index - inStart + 1);

        return root;
    }

    // leetcode 124
    static int max;
    public static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        pathSum(root);
        return max;
    }
    public static int pathSum(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        max = Math.max(max, left+right+node.data);
        return Math.max(left, right) + node.data;
    }

    // leetcode 297: Serialize and Deserialize Binary Tree
//    final static String x = "null";
    // Return a String representation of the Binary Tree
    public static String serialize(TreeNode root){
        if(root == null) return "null";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.data + ", " + left + ", " + right; // PreOrder traversal
    }

    // Solution 1
//    static String[] arr;
//    static int index = 0;

    public static TreeNode deserialize(String data){
         // Solution 1
//    arr = data.split(", ");
//        return deserializeHelper();

        // Solution 2
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    // Solution 1
//    public static TreeNode deserializeHelper(){
//        if(arr[index].equals("null")){
//            index++;
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
//        root.left = deserializeHelper();
//        root.right = deserializeHelper();
//        return root;
//    }

    private static TreeNode deserializeHelper(Queue<String> queue){
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        System.out.println("---preOrder traversal---");
        bt.createBinaryTree();
        System.out.print("Recursive: ");
        preOrderRec(bt.root);
        System.out.println();
        System.out.print("Iterative: ");
        preOrderIterative(bt.root);
        System.out.println();

        System.out.println("---inOrder traversal---");
        System.out.print("Recursive: ");
        inOrderRec(bt.root);
        System.out.println();
        System.out.print("Iterative: ");
        inOrderIterative(bt.root);
        System.out.println();

        System.out.println("---postOrder traversal---");
        System.out.print("Recursive: ");
        postOrderRecursive(bt.root);
        System.out.println();

        System.out.print("Iterative: ");
        postOrderIterative(bt.root);
        System.out.println();

        System.out.println("---Binary Search Tree---");
        BinaryTree bst = new BinaryTree();
        bst.binaryST();
//        bst.createBST(8);
//        bst.createBST(4);
//        bst.createBST(9);
//        bst.createBST(3);
//        bst.createBST(5);

        System.out.print("BST (PO): ");
        postOrderRecursive(bst.root);
        System.out.println();
        System.out.print("BST (LO): ");
        levelOrderRecursive(bst.root);
        System.out.print("BST (IO): ");
        inOrderRec(bst.root);
        System.out.println();
        System.out.print("Is valid BST?: ");
        isValid(bst.root);

        System.out.println("---levelOrder traversal---");
        System.out.print("Recursive: ");
        levelOrderRecursive(bt.root);
        System.out.print("Iterative: ");
        levelOrderIterative(bt.root);
        System.out.println();

        System.out.println("---Find Max---");
        System.out.print("Max TreeNode: ");
        System.out.println(findMax(bt.root));

        System.out.println("---Binary Search Tree---");
        BinaryTree bst2 = new BinaryTree();
        bst2.createBST(5);
        bst2.createBST(3);
        bst2.createBST(7);
        System.out.print("Level order: ");
        levelOrderIterative(bst2.root);
        System.out.println();
        System.out.print("Is valid BST: ");
        isValid(bst2.root);
        System.out.print("In order: ");
        inOrderRec(bst2.root);
//        addNode(bst2.root, 2);
        bst2.createBST(2);
//        addNode(bst2.root, 4);
        bst2.createBST(4);
//        addNode(bst2.root, 6);
        bst2.createBST(6);
        System.out.println();
        System.out.print("BST Level order: ");
        levelOrderRecursive(bst2.root);
        System.out.print("Is valid BST?: ");
        isValid(bst2.root);

        System.out.println("---TreeNode search---");
        levelOrderRecursive(bst2.root);
        int node = 6;
        treeNodeFound(bst2.root, node);
        treeNodeFound(bst2.root, 7);
        treeNodeFound(bst2.root, 1);

        System.out.println("---Is BST valid---");
        BinaryTree bt3 = new BinaryTree();
        bt3.createBST(6);
        bt3.createBST(4);
        bt3.createBST(8);
        bt3.createBST(2);
        bt3.createBST(5);
        bt3.createBST(7);
        bt3.createBST(9);
        bt3.createBST(1);

        levelOrderRecursive(bt3.root);
        System.out.print("Is BST valid: ");
        isValid(bt3.root);

        System.out.println("---Leetcode 226: Invert BST---");
        invertTree(bt3.root);
        System.out.print("Inverted BST: ");
        levelOrderIterative(bt3.root);
        System.out.println();

        System.out.println("---Leetcode 104: Binary Tree Depth---");
        int bTDepth = maxDepth(bt3.root);
        System.out.print("Binary Tree depth: " + bTDepth);
        System.out.println();

        System.out.println("---Leetcode 100: Is Same Tree?---");
        BinaryTree p = new BinaryTree();
        p.createBST(1);
        p.createBST(2);
        p.createBST(3);
        BinaryTree q = new BinaryTree();
        q.createBST(1);
        q.createBST(2);
        q.createBST(3);
        System.out.println(isSameTree(p.root, q.root));

        System.out.println("---Leetcode 572: Is subtree of another binary tree?---");
        System.out.println(isSubtree(bt.root, bst2.root));
        System.out.println(isSubtree(p.root, q.root));

        System.out.println("---Leetcode 235: Lowest Common Ancestor---");
        invertTree(bt3.root);
        levelOrderRecursive(bt3.root);
        System.out.print("Is valid BST: ");
        isValid(bt3.root);
        BinaryTree p2 = new BinaryTree();
        p2.createBST(1);
        BinaryTree q2 = new BinaryTree();
        q2.createBST(2);
        System.out.println(lowestCommonAncestor(bt3.root, p2.root, q2.root).data);

        System.out.println("---Leetcode 102: Return Level order traversal---");
        System.out.print("Iterative: ");
        System.out.println(levelOrderIt(bt3.root));
        System.out.print("Recursive: ");
        System.out.println(levelOrderRec(bt3.root));

        System.out.println("---Kth Smallest---");
        System.out.print("Is valid: ");
        bt3.isValid(bt3.root);
        System.out.print("In-order traversal: ");
        inOrderRec(bt3.root);
        System.out.println();
        System.out.print("Pre-order traversal: ");
        preOrderRec(bt3.root);
        System.out.println();
        int k = 0;
        System.out.print(k + "th smallest: ");
        System.out.println(kthSmallest(bt3.root, k));
        System.out.print(bt.levelOrderIt(bt.root));
        System.out.println();
        System.out.print("Is valid?: " );
        bt.isValid(bt.root);
        System.out.println(kthSmallest(bt.root, 1));

        System.out.println("---construct BT from preorder and inorder traversal---");
        int[] preorder = {3,9,20,15,7,6};
        int[] inorder = {9,3,15,20,6,7};
        TreeNode bt4 = buildTree(preorder, inorder);
        levelOrderRecursive(bt4);

        System.out.println("---Leetcode 124: Get the max subtree path sum---");
        BinaryTree mPS = new BinaryTree();
        mPS.createBST(-10);
        mPS.createBST(9);
        mPS.createBST(20);
//        mPS.createBST(15);
//        mPS.createBST(7);
        System.out.print("Max path sum: ");
        System.out.println(maxPathSum(mPS.root));

        System.out.println("---Leetcode 297: Serialize and deserialize a binary tree---");
        String dSerial = "1,2,3,null,null,4,5";
        System.out.println(serialize(mPS.root));
        System.out.println(serialize(bst.root));
    }
}
