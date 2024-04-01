public class LinkedList {
    public static void main(String[] args) {

        // Defining the Node Class
        class Node {
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

        // Array To Linked List
        int[] arr =  {5, 8, 4, 3, 9};
        Node head = new Node(arr[0]); // head = [5, null];
        Node mover = head; // mover = [5, null];

        // Conversion of Array to Linked List
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); // temp = [8, null];
            mover.next = temp; // mover.next = [8, null]; *Pointer to the next Node*
            mover = mover.next; // mover = [8, null] and so on!
        }

        // Traversing a Linked List
        Node temp = head; // temp = [5, null];
        while (temp != null) { 
            System.out.print(temp.val + " ");
            temp = temp.next; // temp = [8, null] and so on!
        }

        // Length of a Linked List
        Node temp1 = head;
        int count = 0;
        while (temp1 != null) { 
            temp1 = temp1.next; // temp = [8, null] and so on!
            count++;
        }
        System.out.println("\nLength = " + count);
    }
}