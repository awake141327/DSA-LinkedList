class OddEvenLinkedList {

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

    public static Node OddEvenLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node odd = head; // 1, 2, 3, 4, 5
        Node even = head.next; // 2, 3, 4, 5
        Node evenHead = head.next;
        
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // 1 -> 3 -> 5
            odd = odd.next;  // 3, 5
            even.next = even.next.next; // 2 -> 4 -> null;
            even = even.next; // 4, null
        }
        odd.next = evenHead;
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
        int arr[] = {1, 2, 3, 4, 5};
        Node head = Conversion(arr);
        Print(head);
        head = OddEvenLL(head);
        Print(head);
    }
}
