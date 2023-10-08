public class Application {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertToHead(1);
        list.insertToHead(5);
        list.insertToHead(7);
        list.insertToHead(3);
        list.insertToHead(2);
        list.insertToTail(8);
        list.traverse();
        System.out.println("---------");
        list.reverse();
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Insertion at the head
    void insertToHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insertion at the tail
    void insertToTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Deletion from the head
    void deleteFromHead() {
        if (head == null) {
            return; // List is empty, nothing to delete
        }
        head = head.next;
        if (head == null) {
            tail = null; // List is now empty, update tail
        } else {
            head.prev = null;
        }
    }

    // Deletion from the tail
    void deleteFromTail() {
        if (tail == null) {
            return; // List is empty, nothing to delete
        }
        tail = tail.prev;
        if (tail == null) {
            head = null; // List is now empty, update head
        } else {
            tail.next = null;
        }
    }

    // Deletion of a specific element
    void deleteElement(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null) {
            return; // Element not found
        }
        if (current == head) {
            deleteFromHead();
        } else if (current == tail) {
            deleteFromTail();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Searching
    boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Size/Length
    int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Traversal
    void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Reverse Traversal
    void reverse() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }
}



class SinglyLinkedList {
    Node head;
    
    void insertToHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertToTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }       
            temp.next = newNode;
        }
    }

    void deleteHead() {
        if (head != null) {
            head = head.next;           
        } else {
            System.out.println("the list is empty");
        }
    }

    void deleteTail() {
        Node temp = head;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    void insertBefore(int data, int value) {
      Node temp = head;
      Node prev = null;

      if (head.data == data) {
        insertToHead(value);
      } else{
        while (temp != null) {
          if (temp.data == data) {
            Node newNode = new Node(value);
            newNode.next = temp;
            prev.next = newNode;
            break;
          }
          prev = temp;
          temp = temp.next;
        } 
      }
    }

    void insertAfter(int data, int value) {
      Node temp = head;
      Node prev = null;

      while (temp != null) {
        if (temp.data == data) {
          Node newNode = new Node(value);
          newNode.next = temp.next;
          temp.next = newNode;
          break;
        }
        prev = temp;
        temp = temp.next;
      }
    }

    void deleteNode(int data) {
      Node temp = head;
      Node prev = null;

      if (head == null){
        System.out.println("the list is empty");
      } else if (head.data == data) {
        head = head.next;
      } else{
        while (temp != null) {
          if (temp.data == data) {
            prev.next = temp.next;
          }
          prev = temp;
          temp = temp.next;
        }
      }
    }

    void count() {
      int count = 0;
      Node temp = head;
      while (temp != null) {
        temp = temp.next;
        count++;
      }
      System.out.println("The count is: " + count);
    }

    void traverse() {
      Node temp = head;
      while (temp != null) {
          System.out.println(temp.data);
          temp = temp.next;
      }
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
