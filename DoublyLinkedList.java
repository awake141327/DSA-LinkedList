class DoublyLinkedList {

    // Defining the Node Class
    static class Node {
        int val;
        Node next;
        Node back;
                
        Node (int val, Node next, Node back) {
            this.val = val;
            this.next = next;
            this.back = back;
        }
        Node (int val) {
            this.val = val;
            this.next = null;
            this.back = null;
        }
        Node() {  
            this.val = 0;
            this.next = null;
            this.back = null;
        }
    }

    // Converting an Array to a Doubly Linked List
    public static Node convertToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = prev.next;
        }
        return head;
    }

    // Finding the Length of a Doubly Linked List
    public static void printLength(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        System.out.println("Length = " + length);
    }

    // Printing a Doubly Linked List
    public static void print(Node head) {
        System.out.print("DLL = ");
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main Method
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Node head = convertToDLL(arr);
        print(head);
        printLength(head);
    }
}