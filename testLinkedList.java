class testLinkedList {
   public static void main(String... args){
      CircularLinkedList list = new CircularLinkedList();
      
      System.out.println("Circular Doubly Linked list goes here: ");
      list.insertToTail(5);
      list.insertToTail(10);
      list.insertToTail(50);
      list.insertToTail(90);
      list.insertToHead(15);
      list.deleteNode(5);
      list.insertData(10,22);
      list.traverse();
      System.out.println("\n\nReversing Circular Doubly Linked list");
      System.out.println("---------");
      list.reverse();
      System.out.print("Size of linkedlist: ");
      list.Size();
      list.Search(15);
      
      // Doubly Linked List
      System.out.println("\nDoubly Linked list goes here: ");
      DoubleLinkedList newList = new DoubleLinkedList();
      newList.insertToTail(5);
      newList.insertToTail(10);
      newList.insertToTail(50);
      newList.insertToTail(90);
      newList.insertToHead(15);
      newList.deleteNode(5);
      newList.insertData(10,22);
      newList.traverse();
      System.out.println("\n\nReversing Doubly Linked list");
      System.out.println("---------");
      newList.reverseTraverse();
      System.out.print("Size of linkedlist: ");
      newList.size();
      newList.Search(15);
      
   }
}