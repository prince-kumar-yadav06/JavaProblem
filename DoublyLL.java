import java.util.*;
public class DoublyLL {
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
    
   public static Node deleteNode(Node head,int pos){
    // if have one node or not one
    if(head==null || head.next==null){
        System.out.println("empty");
        return null;
    }
    Node temp=head;

    // delete for head 
    if(pos==1){
        temp.next.prev=null;
        head=temp.next;
        temp.next=null;
    }
    // Deletion for middle and last node
    else{
        Node curr=head;
        Node prev=null;
        int cnt=1;
        while(cnt<pos){
            prev=curr;
            curr=curr.next;
            cnt++;
        }
        curr.prev=null;
        prev.next=curr.next;
        curr.next=null;
    }
    return head;
   }
    public static void main(String[] args) {
       Node head=new Node(13);
       head.next=new Node(23);
       head.next.next=new Node(32);
       head.next.next.next=new Node(45);
       head.next.next.next.next=new Node(65);
      print(head);
      head=deleteNode(head, 2);
      print(head);
    }
}
