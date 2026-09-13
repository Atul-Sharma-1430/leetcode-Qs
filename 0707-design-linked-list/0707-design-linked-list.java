class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class MyLinkedList {
    Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {

        // temp lenge for traversal
        Node temp = head;
        // count to track index
        int count = 0;

        // last tak  jaayenge
        while (temp != null) {
            // agar index pe pahuch gye toh data retun kr do
            if (count == index) {
                return temp.data;
            }

            count++;
            temp = temp.next;
        }

        // else -1 return kr do agar valid index nhi h toh
        return -1;
    }

    public void addAtHead(int val) {
        // new node banayenge with given value
        Node newHead = new Node(val);
        // new node ke next ko head wale pe point kr denge 
        newHead.next = head;
        // head ko new node pe point kr denge
        head = newHead;
    }

    public void addAtTail(int val) {

        // Agar Linked List empty hai
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node temp = head;

        // Last node tak jayenge
        while (temp.next != null) {
            temp = temp.next;
        }

        // New node banayenge for given data
        Node newNode = new Node(val);
        // and temp ke next ko newNOde pe point kr denge
        temp.next = newNode;
        // newNode ke next ko nullpe point kr denge
        newNode.next = null;
    }

    public void addAtIndex(int index, int val) {

        // Agar index 0 hai to new node head banega
        if (index == 0) {
            head = new Node(val, head);
            return;
        }

        // Length count karenge
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Agar index Linked List ke size se bada hai
        if (index > len) {
            return;
        }

        Node temp1 = head;
        int count = 0;
        // Index se just pehle wale node tak jayenge
        while (count < index - 1) {
            count++;
            temp1 = temp1.next;
        }

        Node newNode = new Node(val);
        // new wale node ke next ko abhi temp1 ka next jaha point kr rha hai waha pe point krenge
        newNode.next = temp1.next;
        // and uske baad temp1 ke next ko newNode pe point krwa denge
        temp1.next = newNode;
    }

    public void deleteAtIndex(int index) {

        // Agar Linked List empty hai
        if (head == null) {
            return;
        }

        // Agar first node delete karna hai
        if (index == 0) {
            head = head.next;
            return;
        }

        // Length count karenge
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Agar index Linked List ke size se bada hai
        if (index >= len) {
            return;
        }

        Node temp1 = head;
        int count = 0;
        // Index se just pehle wale node tak jayenge
        while (count < index - 1) {
            count++;
            temp1 = temp1.next;
        }

        // Current node ko skip kar denge
        temp1.next = temp1.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */