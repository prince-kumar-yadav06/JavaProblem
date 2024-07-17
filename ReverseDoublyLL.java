import java.util.*;
public class ReverseDoublyLL {
    static Node head;
    static Node tail;
   static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;

        }
    }
    public static void add(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;

        }

        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    public static void print(Node head){
        if(head==null){
            return;
        }
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println();
    }
    
  
   public static Node Reverse(Node head){
    Node curr=head;
    Node prev=null;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        curr.prev=next;

        prev=curr;
        curr=next;
    }
    return prev;

   }

    public static void main(String[] args) {
       Node head=new Node(13);
       head.next=new Node(23);
       head.next.next=new Node(32);
       head.next.next.next=new Node(45);
       head.next.next.next.next=new Node(65);
      print(head);
     head=Reverse(head);

      print(head);
    }
}
