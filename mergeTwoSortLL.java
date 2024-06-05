import java.util.*;
public class mergeTwoSortLL{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data,Node next1){
            this.data=data;
            this.next=next1;
        }
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
     static  Node merge(Node head1,Node head2){
        Node ptr1=head1;
        Node ptr2=head2;
        Node dummy=new Node(-1);   //dummy initialize with -1//
        Node temp=dummy;

        while(ptr1!=null && ptr2 !=null){
            // jis head ka value small hoga use store kra denge temp me aur uska pointer ko ek age move kr denge

            if(ptr1.data<ptr2.data){
                temp.next=ptr1; 
                ptr1=ptr1.next;

            }
            else{
                temp.next=ptr2;
                ptr2=ptr2.next;
            }
            temp=temp.next;
        }
        // suppose koi list null hogya aur koi list me abhi v node haito uske liye phir se while loop likh lete hai
        while(ptr1!=null){
            temp.next=ptr1;
            ptr1=ptr1.next;
            temp=temp.next;
        }
        while(ptr2!=null){
            temp.next=ptr2;
            ptr2=ptr2.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        Node head1=new Node(1);
        head1.next=new Node(7);
        head1.next.next=new Node(8);
        head1.next.next.next=new Node(9);
        System.out.println("1st List");
        print(head1);

        Node head2 =new Node(2);
        head2.next=new Node(3);
        head2.next.next=new Node(6);
        System.out.println("2nd List");

        print(head2);

        Node aftermerge=merge(head1, head2);
        System.out.println("After merge");
        print(aftermerge);
    }
}