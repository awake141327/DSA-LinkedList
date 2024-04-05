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
    
    // Finding the Middle of a Linked List
    public static Node middleOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        int arr[] = {1, 2, 3, 4, 5, 6};
        Node head = Conversion(arr);
        Print(head);
        head = middleOfLinkedList(head);
        Print(head);
    }
}