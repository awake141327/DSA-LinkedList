class InsertionDLL {

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
        if (arr.length == 0) {
            return null;
        }
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

    // Insertion Before the Head of a Doubly Linked List
    public static Node insertBeforeHead(Node head, int val) {
        // [null, 1, 2, 3, 4, 5, null];  [null, <-0->, <-1->, 2, 3, 4, 5, null]
        Node temp = new Node(val, head, null);
        head.back = temp;
        return temp;
    }

    // Insertion After the Head of a Doubly Linked List
    public static Node insertAfterHead(Node head, int val) {
        // [null, 1, 2, 3, 4, 5, null];  [null, <-1->, <-6->, 2, 3, 4, 5]
        Node temp = new Node(val, head.next, head);
        head.next = temp;
        return head;
    }

    // Insertion Before the Tail of a Doubly Linked List
    public static Node insertBeforeTail(Node head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return insertBeforeHead(head, val);
            
        }
        Node front = head;
        while(front.next != null) {
            front = front.next;
        }
        Node prev = front.back;
        Node temp = new Node(val, front, prev);
        prev.next = temp;
        front.back = temp;
        return head;
    }

    // Insertion After the Tail of a Doubly Linked List
    public static Node insertAfterTail(Node head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return insertAfterHead(head, val);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newTail = new Node(val, null, temp);
        temp.next = newTail;
        return head;
    }

    // Insertion Before the Kth Node of a Doubly Linked List
    public static Node insertBeforeKthNode(Node head, int val, int k) {
        // [null, 1, 2(prev), 3(temp), 4, 5, null]; [null, 1, 2]
        if (k == 1) {
            return insertBeforeHead(head, val);
        }
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count ++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        if (prev == null) return insertBeforeHead(head, val);
        else if (temp.next == null) return insertBeforeTail(head,val);
        Node newNode = new Node(val, temp, prev);
        temp.back = newNode;
        prev.next = newNode;
        return head;
    }

    // Insertion After the Kth Node of a Doubly Linked List
    public static Node insertAfterKthNode(Node head, int val, int k) {
        // [null, 1, 2, 3, 4, 5, null] => [null, 1, 2, 3, 9, 4, 5, null];
        if (k == 1) {
            return insertAfterHead(head, val);
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) break;
            temp = temp.next;
        }
        Node front = temp.next;
        Node newNode = new Node(val, temp.next, temp);
        temp.next = newNode;
        front.back = newNode;
        return head;
    }

    // Insertion Before a Given Node of a Doubly Linked List
    public static void insertBeforeNode(Node temp, int val) {
        // [null, 1, 2(prev), 9(newNode), 3(temp), 4, 5, null]
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev); 
        prev.next = newNode;
        temp.back = newNode;
    }

    // Insertion After a Given Node of a Doubly Linked List
    public static void insertAfterNode(Node temp, int val) {
        // [null, 1, 2, 3(temp), 4, 5, null]
        Node front = temp.next;
        Node newNode = new Node(val, front, temp);
        front.back = newNode;
        temp.next = newNode;
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
        head = insertBeforeHead(head, 0);
        print(head);
        head = insertAfterHead(head, 6);
        print(head);
        head = insertBeforeTail(head, 6);
        print(head);
        head = insertAfterTail(head, 6);
        print(head);
        head = insertBeforeKthNode(head, 7, 3);
        print(head);
        head = insertAfterKthNode(head, 9, 3);
        print(head);
        insertBeforeNode(head.next.next, 8);
        print(head);
        insertAfterNode(head.next.next, 8);
        print(head);
    }
}