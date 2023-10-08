public class CicularLinkedListCeniza {
    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
            }
}

class CircularLinkedList{
   Node head;
   Node tail;
   
   void insertToHead(int data){
      Node newNode = new Node(data);
      if(head == null){
         head = newNode;
         tail = newNode;
      }
      else {
         head.prev = newNode;
         newNode.next = head;
         head = newNode;
         head.prev = tail;
      }
   }
   
   void insertToTail(int data){
      Node newNode = new Node(data);
      if(tail == null){
         head = newNode;
         tail = newNode;
      } else {
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
         tail.next = head;
      }
   }
   
   void traverse(){
      Node temp = head;
      Node last = tail;
      
      if(head == null){
         System.out.println("No available list.");
      }else {
         do{
            System.out.println(temp.data + " ");
            temp = temp.next;
            if(temp.next == tail){
               System.out.println(temp.data + " ");
               temp = temp.next;
               System.out.println(temp.data + " ");
            }
         }while(temp != last);
      }
   }
   
   void reverse(){
      Node temp = head;
      Node last = tail;
      
      if(tail == null){
         System.out.println("No available list.");
      }else {
         do{
            System.out.println(last.data + " ");
            last = last.prev;
            if(last.prev == head){
               System.out.println(last.data + " ");
               last = last.prev;
               System.out.println(last.data + " ");
            }
         }while(last != temp);
      }
   }
   
   void deleteHead(){
      if(head == null){
         System.out.println("No available list.");
      } else {
         head = head.next;
         head.prev = tail;
      }
   }
   
   void deleteTail(){
      if(tail == null){
         System.out.println("No available list.");
      }else {
         tail = tail.prev;
         tail.next = head;
      }
   }
   
   void deleteNode(int target){
      Node currentHead = head;
      Node currentTail = tail;
      Node prevHead = null;
           
      if(target == currentHead.data){
         deleteHead();
      } else if(target == currentTail.data){
         deleteTail();
      }
      else{
         while(currentHead != currentTail){
            if(currentHead.data == target){
               currentHead = currentHead.next;
               prevHead.next = currentHead;
               currentHead.prev = prevHead;
            }
            prevHead = currentHead;
            currentHead = currentHead.next;
         }
      }
   }
   
   
   void insertData(int data, int value){
      Node currentHead = head;
      Node currentTail = tail;
      Node prevHead = null;
      
      if(data == head.data){
         insertToHead(value);
      }else if(data == tail.data){
         insertToTail(value);
      }
      else {
         while(currentHead != currentTail){
            if(currentHead.data == data){
               Node newNode = new Node(value);
               prevHead = currentHead;
               currentHead = currentHead.next;
               newNode.next = currentHead;
               currentHead.prev = newNode;
               prevHead.next = newNode;
               newNode.prev = prevHead;
            }
            
            prevHead = currentHead;
            currentHead = currentHead.next;
         }
      }
   }
   
   void Size(){
      Node temp = head;
      int countElement=1;
      if(temp == null){
         System.out.println("No list available.");
      } else {
         while(temp != tail){
            countElement++;
            temp = temp.next;
         }
         System.out.println(countElement);
      }
   }
   
   void Search(int Target){
      Node currentHead = head;
      Node currentTail = tail;
      if(head == null){
         System.out.println("No data in the list.");
      }
      else if(Target == head.data){
         System.out.println("The target is in the head of the list: " + Target + " data: " + currentHead.data);
      }
      else if(Target == tail.data){
         System.out.println("The target is in the tail of the list: " + Target + " data: " + currentTail.data);
      }
      else {
         while(currentHead != tail){
            if(currentHead.data == Target){
               System.out.println("The target is in the list: " + Target + " data: " + currentHead.data);
            }
            currentHead = currentHead.next;
         }
      }
   }
}

class Node {
   int data;
   Node next;
   Node prev;
   Node(int data){
      this.data = data;
   }
}