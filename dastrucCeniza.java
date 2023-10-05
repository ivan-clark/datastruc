public class dastrucCeniza {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.insertToHead(68);
        list.insertAtPosition(69, 2);
        list.insertToHead(67);
        list.insertToHead(66);
        list.insertToHead(65);
        list.insertToHead(69);
        list.insertToTail(123);
        list.insertToTail(54);
        list.insertToTail(243);
        
        list.insertAtPosition(54, 68);
        
        list.deleteFromTail();
        list.deleteAtPosition(2);

        list.traverse();
        System.out.println("-------------");
        list.reverse();
        
        System.out.println("List Size: " + list.size());
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    void insertToHead(int data) {
        Node newNode = new Node(data);
        //check if list is empty
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertToTail(int data) {
        Node newNode = new Node(data);
        //check if list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void reverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            insertToHead(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
        newNode.prev = temp;

        if (temp == tail) {
            tail = newNode;
        }
    }

    void deleteFromHead() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from head.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    void deleteFromTail() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete from tail.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    void deleteAtPosition(int data) {
        Node temp = head;

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found in the list.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    boolean search(int data) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == data) {
                return true; // Element found
            }
            temp = temp.next;
        }

        return false; // Element not found
    }

    int size() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}


class Node {
    int data;
    Node next;
    Node prev;


    Node(int data) {
        this.data = data;
    }
}