import java.util.Stack;

public class ReverseLL {

    // Defining the Node Class
    static class Node {
        int val;
        Node next;
                
        Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
        Node (int val) {
            this.val = val;
            this.next = null;
        }
        Node() {  
            this.val = 0;
            this.next = null;
        }
    }

    // Converting Array to Linked List
    public static Node Conversion(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    // Finding the Length of a Linked List
    public static int Count(Node head) {
        int count = 0;
        while (head != null) { 
            head = head.next;
            count++;
        }
        return count;
    }

    // Reversing a Linked List using Stack
    // Time Complexity = O(2N), Space Complexity = O(N)
    public static Node reverseLL(Node head) {
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.val = st.peek();
            st.pop();
            temp = temp.next;
        }
        return head;
    }

    // Reversing a Linked List without using any External Data Structure
    public static Node reverseLL1(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // Printing a Linked List
    public static void Print(Node head) {
        while (head != null) { 
            System.out.print(head.val + " ");
            head = head.next; 
        }
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5};
        Node head = Conversion(arr);
        Print(head);
        head = reverseLL(head);
        Print(head);
        head = reverseLL(head);
        Print(head);
    }
}