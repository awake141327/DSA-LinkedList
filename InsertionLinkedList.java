class InsertionLinkedList {

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

    // Insertion at Head of a Linked List
    public static Node addAtHead(Node head, int val) {
        // Node temp = new Node(val, head) --> 1 Liner to add at Head.
        Node temp = new Node(val); // temp = [1, null];
        temp.next = head; // temp = [1, ptr to Node(2)]
        head = temp; // head = [1, ptr to Node(2)]
        return head; 
    }

    // Insertion at Tail of a Linked List
    public static Node addAtTail(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }

        Node newTail = new Node(val);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next; 
        }
        temp.next = newTail;
        return head;
    }

    // Insertion at any given Index of a Linked List
    public static Node addAtIndex(Node head, int val, int index) {
        if (head == null) {
            if (index == 1)
                return new Node(val);
            else
                return null;
        }
        if (index == 1) {
            Node temp = new Node(val, head);
            return temp;
        }

        int count = 0;
        Node temp = head;
        Node newNode = new Node(val); // newNode = [5, ptr to null];
        while (temp != null) { // true, true
            count++; // 1, 2
            if (count == (index - 1)) { // 1 = 2 ? false, 2 = 2 ? true
                newNode.next = temp.next; // [5, null] -> [5, ptr to 6]
                temp.next = newNode; // temp.next = 4 ptr to newNode [5, ptr to 6]
                break;
            }
            temp = temp.next; // temp = 2, 4
        }
        return head;
    }

    // Insertion of a Node by Value before a given Index.
    public static Node addBeforeElement(Node head, int val, int ele) {
        if (head == null) {
           return null;
        }
        if (head.val == ele) {
            return new Node(val, head);
        }

        int count = 0;
        Node temp = head;
        Node newNode = new Node(val);
        while (temp.next != null) { 
            count++; 
            if (temp.next.val == ele) { 
                newNode.next = temp.next; 
                temp.next = newNode; 
                break;
            }
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
        int arr[] = {2, 4, 6, 8};
        Node head = Conversion(arr);
        Print(head);
        head = addAtHead(head, 1);
        Print(head);
        head = addAtTail(head, 9);
        Print(head);
        head = addAtIndex(head, 5, 3);
        Print(head);
        head = addBeforeElement(head, 7, 8);
        Print(head);
    }
}