public class monsanto
{
   public static void main(String args[])
   {
         doublelinkedlist list = new doublelinkedlist();
         list.InsertionToTail(1);
         list.InsertionToTail(2);
         list.InsertionToTail(3);
         list.InsertionToTail(4);
         list.InsertionToTail(5);
        // list.InsertionToTail(2);
         list.DeleteFromHead();
         list.DeleteAt(3);
         list.size();
         list.DeleteFromTail();
         list.traverse();
         System.out.println();
         list.Search(2);
         System.out.println("___________________");  
         //list.traverse();
         
         list.reverse();
         
   }

}
class node
{
   int data;
   node next;
   node prev;
   node(int data)
   {
      this.data = data;
   }
      
}
class doublelinkedlist
{
   node head;
   node back;
   
   void InsertionToTail(int data) {
    node newNode = new node(data);
    if (head == null) {
      head = newNode;
      back = newNode;
    } else {
      newNode.prev = back;
      back.next = newNode;
      back = newNode;
    }
  }
  void insertToHead(int data) {
    node newNode = new node(data);
    if(head == null) {
      head = newNode;
      back = newNode;
    }
    else{
      newNode.next = head; 
      head.prev = newNode;
      head = newNode;
    }
  }  
  void reverse() {
    node temp = back;
    while (temp != null) {
      System.out.print(temp.data+" ");
      temp = temp.prev;
    }
  }

  
  
   void traverse()
   {
      node temp =  head;
      while(temp != null)
      {
         System.out.print(temp.data+" ");
         temp = temp.next;
      }   
   }
   void InsertAt()
   {
   
   }
   void DeleteFromHead()
   {
      node temp = back;
      if(back != null)
      {
         back = back.prev;
      }
      else
      {
         System.out.println("Nothing in there ");
      }
   }
   void DeleteFromTail()
   {
      node delete = head;
      if(head == null || head.next == null)
      {
         head = null;
      }
      while(delete.next != null)
      {
         delete = delete.next;
      }  
      delete = delete.prev.next = null;
      
   }
   public node DeleteAt(int data)
   {
      if(head == null)
      {
      return head;
      }
      if(data == 1)
      {
         if(head.next != null)
         {
            head.next.prev = null;
         }
         head = head.next;
      }
      node temp = head;
      while(temp != null && data > 1)
      {
         temp = temp.next;
          data --;
      }
      if(temp == null)
      {
         System.out.println("Nothing in there !! ");
         return head;
      }
      if(temp.next != null)
      {
         temp.next.prev = temp.prev;
      }
      temp.prev.next = temp.next;
      return head;
      
   }
   void Search(int Target){
      node temp = head;
      node temp1 = back;
      if(head == null){
         System.out.println("No data in the list.");
      }
      else if(Target == back.data){
         System.out.println("The target is in the head of the list: " + Target + " data: " + temp.data);
      }
      else if(Target == back.data){
         System.out.println("The target is in the tail of the list: " + Target + " data: " + temp1.data);
      }
      else {
         while(temp != back){
            if(temp.data == Target){
               System.out.println("The target is in the list: " + Target + " data: " + temp.data);
            }
            temp = temp.next;
         }
      }
 }

   void size()
   {
      int data = 0;
      node size = new node(data);
      size = head.next;
      node temp = size  ;
      if(temp == null)
      {
        System.out.println("Nothing in there !! ");
      }
      int count = 0;
      while(temp != null)
      {
         temp = temp.next;
         count++;
         
      }
      System.out.println("The Size is : "+count);
      temp= temp;
   }

}