import java.util.*;
public class mergeLL{
    static Node head;
    static class Node{
        int data;
        Node next;

         Node(int data){
            this.data=data;
            this.next=null;
         }
    }
    public static Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=findmid(head);
        Node left=head;
        Node right=mid.next;
        mid.next=null;

        left=mergesort(left);
        right=mergesort(right);

        Node ans=merge(left,right);
        return ans;
    }
   public static Node findmid(Node head){
    Node slow=head;
    Node fast=head.next;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
   }
   public static Node merge(Node left,Node right){
       if(left==null){
           return right;
        }
        else if(right==null){

            return left;
        }
        
        Node temp=new Node(-1);
        Node curr=temp;
        if(left.data<right.data){
            curr.next=left;
            left.next=merge(left.next, right);
        }
        else{
            curr.next=right;
            right.next=merge(left, right.next);
        }
    return temp.next;
   }
   public static void print(Node head){
    Node curr=head;
    while(curr!=null){
        System.out.print(curr.data+" ");
        curr=curr.next;
    }
    System.out.println();
   }
   public static void main(String args[]){
    Node head=new Node(2);
    head.next=new Node(1);
    head.next.next=new Node(7);
    head.next.next.next=new Node(4);
    print(head);

    head=mergesort(head);
    print(head);
   }
}
