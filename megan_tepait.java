public class megan_tepait {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertToHead(8);
        list.insertToHead(9);
        list.insertToHead(2);
        list.insertToHead(3);
        list.insertToHead(1);
        list.insertToTail(5);
        list.traverse();
        System.out.println("---------");
        list.deleteNode(3);
        list.reverse();

        System.out.println("Size: " + list.size());
    }
}

class DoubleLinkedList {
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


  //delet to head
    void deleteFromHead() {
        if (head != null) {
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
        } else {
            System.out.println("The list is empty");
        }
    }



  //detetotail
  void deleteTail() {
    if (tail != null) {
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
    } else {
        System.out.println("The list is empty");
    }
}

// Deletion of a Specific Element
 void deleteNode(int data) {
    Node temp = head;
    while (temp != null) {
        if (temp.data == data) {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                // If the node to delete is the head
                head = temp.next;
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                // If the node to delete is the tail
                tail = temp.prev;
            }
            break;
        }
        temp = temp.next;
    }
}

//Size/Length
 int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }



  void reverse() {
    Node temp = tail;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.prev;
    }
  }
}

/**class SinglyLinkedList {
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
}**/

class Node {
    int data;
    Node next;
    Node prev;


    Node(int data) {
        this.data = data;
    }
}