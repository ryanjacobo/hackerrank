import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class SingleStack {
    private StackNode top;
    private int length;

    private static class StackNode {
        private int data;
        private StackNode next;

        public StackNode(int data) {
            this.data = data;
//            this.next = null;
        }
    }

    // SingleStack constructor
    public SingleStack() {
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data) {
        StackNode temp = new StackNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public void pop(){
        if(isEmpty()){
            return;
        }
        top = top.next;
        length--;
    }

    public int popNode(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    // shows the top of the stack
    public int peek(){
        if(isEmpty()){
           throw new EmptyStackException();
        }
        return top.data;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return;
        }

        StackNode current = top;
        System.out.print("null");
        while(current != null){
            System.out.print(" <- " + current.data);
            current = current.next;
        }
        System.out.print("(bottom)");
        System.out.println();
    }

    public static String reverse(String str){
        // in Stack, Stack<Character> stack = new Stack<>();
        SingleStack strStack = new SingleStack();
        char[] chars = str.toCharArray();
        for(char c : chars){
            strStack.push(c);
        }

        for(int i = 0; i < str.length(); i++){
            chars[i] = (char) strStack.popNode();
        }
        return new String(chars);
    }

    // use of a LIFO list
    public static int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        SingleStack stack = new SingleStack();
        // loop starting from last element
        for(int i = arr.length - 1; i>=0; i--){
            // if stack is not empty, check if the top element in the stack is <= arr[i]
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop(); // remove the element if it's less than arr[i]. if stack.peek() is > arr[i], exit out of while-loop and proceed to next if.
                }
            }
            if(stack.isEmpty()){
                result[i] = -1; // no element greater than arr[i], result[i] is -1 (and added to result[])
            } else {
                result[i] = stack.peek(); // the stack.peek() is greater than arr[i] therefore add that element to result[]
            }
            stack.push(arr[i]); // push arr[i] to stack to compare it to the next arr[i]
        }
        return result;
    }

    public static void main(String[] args) {
        SingleStack sS1 = new SingleStack();
        sS1.push(1);
        sS1.push(2);
        sS1.display();
        System.out.println(sS1.peek());

        sS1.pop();
        sS1.display();
        sS1.pop();
        sS1.display();

        String str = "ABCD";
        System.out.println(reverse(str));

        int[] intArr = {4,7,3,4,8,1};
        System.out.println(Arrays.toString(nextGreaterElement(intArr)));
    }
}
