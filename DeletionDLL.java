class DeletionDLL {

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

    // Deletion at Head of a Doubly Linked List
    public static Node deleteAtHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        } 
        // [null, 1, 2, 3, 4, 5, null];
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        
        return head;
    }

    // Deletion at Tail of a Doubly Linked List
    public static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        // [null, 1, 2, 3, 4, 5, null];
        Node temp = head;
        while (temp.next!= null) {
            temp = temp.next;
        }
        Node prev = temp.back;
        prev.next = null;
        temp.back = null;
        return head;
    }

    // Deletion at Kth Element of a Doubly Linked List
    public static Node deleteAtKthElement(Node head, int k) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }

        Node prev = temp.back;
        Node front = temp.next;
        if (prev == null && front == null) return null;
        else if (prev == null) return deleteAtHead(temp);
        else if (front == null) return deleteAtTail(temp);

        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;
        return head;
    }

    // Deleting a given Node from a Doubly Linked List
    public static void deleteNode(Node temp) {
        Node prev = temp.back;
        Node front = temp.next;

        if (front == null) {
            prev.next = null;
            temp.back = null;
        }
        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;
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
        head = deleteAtHead(head);
        print(head);
        head = deleteAtTail(head);
        print(head);
        head = deleteAtKthElement(head, 3);
        print(head);
        deleteNode(head.next.next);
        print(head);
    }
}