public class DeletionLinkedList {

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

    // Deletion at Head of a Linked List
    public static Node deleteAtHead(Node head) {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    // Deletion at Tail of a Linked List
    public static Node deleteAtTail(Node head) {
        if (head == null || head.next == null)
            return null;
        
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // Deletion at any given Index of a Linked List
    public static Node deleteAtIndex(Node head, int index) {
        if (head == null)
            return head;
        if (index == 1) {
            head = head.next;
            return head;
        }

        Node temp = head;
        int count = 0;
        Node prev = null;
        while(temp != null) {
            count++;
            if (count == index) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // Deletion of a Node by its given Value.
    public static Node deleteByValue(Node head, int val) {
        if (head == null)
            return null;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.val == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        } 
        return head;
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
        int arr[] = {2, 4, 6, 8, 5, 2, 1};
        Node head = Conversion(arr);
        Print(head);
        head = deleteAtHead(head);
        Print(head);
        head = deleteAtTail(head);
        Print(head);
        head = deleteAtIndex(head, 3);
        Print(head);
        head = deleteByValue(head, 4);
        Print(head);
    }
}