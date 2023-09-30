class App {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertToHead(1);
        list.insertToHead(5);
        list.insertToHead(7);
        list.insertToHead(3);
        list.insertToHead(2);

        list.insertToTail(8);
        list.insertToTail(23);
        list.insertToTail(25);
        list.insertAtPosition(10, 5);
        list.deleteFromHead();
        list.deleteFromTail();
        list.deleteAtPosition(5);

        if (list.search(3)) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }

        list.traverse();
        System.out.println("---------");
        list.reverse();
        System.out.println("The size of the list: " + list.size());
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

//class SinglyLinkedList {
//    Node head;
//
//    void insertToHead(int data) {
//        Node newNode = new Node(data);
//        newNode.next = head;
//        head = newNode;
//    }
//
//    void insertToTail(int data) {
//        Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//        } else {
//            Node temp = head;
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//            temp.next = newNode;
//        }
//    }
//
//    void deleteHead() {
//        if (head != null) {
//            head = head.next;
//        } else {
//            System.out.println("the list is empty");
//        }
//    }
//
//    void deleteTail() {
//        Node temp = head;
//        Node prev = null;
//        while (temp.next != null) {
//            prev = temp;
//            temp = temp.next;
//        }
//        prev.next = null;
//    }
//
//    void insertBefore(int data, int value) {
//        Node temp = head;
//        Node prev = null;
//
//        if (head.data == data) {
//            insertToHead(value);
//        } else{
//            while (temp != null) {
//                if (temp.data == data) {
//                    Node newNode = new Node(value);
//                    newNode.next = temp;
//                    prev.next = newNode;
//                    break;
//                }
//                prev = temp;
//                temp = temp.next;
//            }
//        }
//    }
//
//    void insertAfter(int data, int value) {
//        Node temp = head;
//        Node prev = null;
//
//        while (temp != null) {
//            if (temp.data == data) {
//                Node newNode = new Node(value);
//                newNode.next = temp.next;
//                temp.next = newNode;
//                break;
//            }
//            prev = temp;
//            temp = temp.next;
//        }
//    }
//
//    void deleteNode(int data) {
//        Node temp = head;
//        Node prev = null;
//
//        if (head == null){
//            System.out.println("the list is empty");
//        } else if (head.data == data) {
//            head = head.next;
//        } else{
//            while (temp != null) {
//                if (temp.data == data) {
//                    prev.next = temp.next;
//                }
//                prev = temp;
//                temp = temp.next;
//            }
//        }
//    }
//
//    void count() {
//        int count = 0;
//        Node temp = head;
//        while (temp != null) {
//            temp = temp.next;
//            count++;
//        }
//        System.out.println("The count is: " + count);
//    }
//
//    void traverse() {
//        Node temp = head;
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }
//}

class Node {
    int data;
    Node next;
    Node prev;


    Node(int data) {
        this.data = data;
    }
}
