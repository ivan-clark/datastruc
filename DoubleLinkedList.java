class DoubleLinkedList{
   Node head;
   Node tail;
   
   
   void insertToHead(int data){
      Node newNode = new Node(data);
      
      if(head == null){
         head = newNode;
         tail = newNode;
      } else {
         head.prev = newNode;
         newNode.next = head;
         head = newNode;
         
      }
   }
   
   void insertToTail(int data){
      Node newNode = new Node(data);
      if(head == null){
         head = newNode;
         tail = newNode;
      } else {
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
      }
   }
   
   void traverse(){
      Node temp = head;
      while(temp != null){
         System.out.println("----");
         System.out.print("| " +temp.data + " | \t \n");
         System.out.println("----");
         temp = temp.next;
      }
   }
   
   void reverseTraverse(){
      Node temp = tail;
      while(temp != null){ 
         System.out.println("----");
         System.out.print("| " +temp.data + " | \t \n");
         System.out.println("----");
         temp = temp.prev;
      }
   }
   
   void deleteHead(){
      if(head != null){
         head = head.next;
         head.prev = null;
      } else {
         System.out.println("Si kinsa imong iremove? hangin?");
      }
   }
   
   void deleteTail(){
      Node temp = tail;
      
      if(temp == head){
         deleteHead();
      }
      else{
         tail = tail.prev;
         tail.next = null;
      }
   }
   
   void deleteNode(int data){
      Node temp = head;
      Node last = tail;
      Node prev = head.prev;
      if(head == null) {
         System.out.println("No data on the list."); 
      } 
      else if(data == last.data) {
         deleteTail();
      }
      else if(data == head.data) {
         deleteHead();
      }
      else {
         while(temp != null){
            if(temp.data == data){
               temp = temp.next;
                  prev.next = temp;
                  temp.prev = prev;
                  
            }
            prev = temp;
            temp = temp.next;
            
         }
      }
   }
   void insertData(int data, int value){
      Node first = head;
      Node last = tail;
      Node prev = head.prev;
      if(data == first.data){
         insertToHead(value);
      } else if(data == last.data){
         insertToTail(value);
      }else {
         while(first != null){
            if(first.data == data){
               Node newNode = new Node(value);
               prev = first;
               first = first.next;
               prev.next = newNode;
               newNode.prev = prev;
               newNode.next = first;
               first.prev = newNode;
               break;
            }
            prev = first;
            first = first.next;
         }
      }
   }
   
   void size(){
      Node temp = head;
      int countElement=0;
      while(temp != null){
         countElement++;
         temp = temp.next;
      }
      System.out.println(countElement);
   }
   
   void Search(int Target){
      Node temp = head;
      Node prev = tail;
      if(head == null){
         System.out.println("No data in the list.");
      }
      else if(Target == head.data){
         System.out.println("The target is in the head of the list: " + Target + " data: " + temp.data);
      }
      else if(Target == tail.data){
         System.out.println("The target is in the tail of the list: " + Target + " data: " + prev.data);
      }
      else {
         while(temp != null){
            if(temp.data == Target){
               System.out.println("The target is in the list: " + Target + " data: " + temp.data);
            }
            temp = temp.next;
         }
      }
   }
}

class Node{
   int data;
   Node next;
   Node prev;
   
   Node(int data){
      this.data = data;
   }
}