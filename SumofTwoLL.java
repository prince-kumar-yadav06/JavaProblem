import java.util.*;
public class sumofTwoLL{
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void sumll(Node first,Node second){
        Node temp1=first;
        Node temp2=second;
        int sum2=0;
        int sum1=0;
        while(temp1!=null && temp2!=null){
            sum1=sum1*10+temp1.data;
            sum2=sum2*10+temp2.data;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp2!=null){
            sum2=sum2*10+temp2.data;
            temp2=temp2.next;
        }
        int ans=sum1+sum2;
        System.out.println(ans);
    }
    public static void main(String args[]){
        Node first=new Node(5);
        first.next=new Node(6);
        first.next.next=new Node(3);

        Node second=new Node(8);
        second.next=new Node(4);
        second.next.next=new Node(2);

        sumll(first,second);
    }
    
}
