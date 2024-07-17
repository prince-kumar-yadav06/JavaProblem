
import java.util.*;
public class BiotonicLL{  //Biotonic is a doubly linked list first vlaue in accending order then in deccending
    static Node head;
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
    public static Node push(Node head,int data){
        
        Node newdata=new Node(data);

        newdata.next=head;
        if(head!=null){
            head.prev=newdata;
        }
        head=newdata;
        return head;
    }
    public static Node findmid(Node start){
        Node slow=start;
        Node fast=start.next;
        while( fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
    return slow;
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
       right= mergesort(right);
        Node result=mergeBothList(left,right);
        return result;

    }
    public static Node mergeBothList(Node left,Node right){
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        Node ans=new Node(0);
        Node temp=ans;
        while(left!=null && right!=null){
            if(left.data<right.data){
                left.next=mergeBothList(left.next, right);
                left.next.prev=left;
                left.prev=null;
                return temp.next=left;
            }
            else{
                right.next=mergeBothList(left, right.next);
                right.next.prev=right;
                right.prev=null;
                return temp.next=right;
                
            }
        }
       
        ans=ans.next;
        return ans;
       
    }
    public  static void print(Node Head){
        Node temp=Head;
        if(temp==null){
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    
    
public static void main(String[] args) {
    

    Node head=null;
    head=push(head, 1);
    head=push(head, 4);
    head=push(head, 6);
    head=push(head, 10);
    head=push(head, 12);
    head=push(head, 7);
    head=push(head, 5);
    head=push(head, 2);
    print(head);
   head= mergesort(head);
    print(head);

}
}
    
    

