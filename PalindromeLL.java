public class PalindromeLL {

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

    // Reversing a Linked List
    public static Node reverse(Node head) {
        Node temp = head;
        Node prev = null;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // Checking if a Linked List is Palindrome
    public static boolean isPalindrome(Node head) {
        Node slow = head; // 1,2,3,3,2,1
        Node fast = head; // 1,2,3,3,2,1
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverse(slow.next); // 3, 2, 1 => 1, 2, 3
        Node first = head;
        Node second = newHead;
        while(second!=null) {
            if (first.val != second.val) {
                reverse(newHead);
                return false;
            }
            
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
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
        int arr[] = {1, 2, 3, 4, 5};
        Node head = Conversion(arr);
        Print(head);
        System.out.println(isPalindrome(head));
    }
}