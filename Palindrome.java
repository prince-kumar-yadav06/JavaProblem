import java.util.*;
public class Palindrome {
    

static Node head;
 class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;

    }
}
public void add(int data){
    Node curr=new Node(data);
    if(head==null){
        head=curr;
        return;
    }
    curr.next=head;
    head=curr;
}
public void print(Node head){

    while(head!=null){
        System.out.print(head.data+"-->");
        head=head.next;
    }
    System.out.println("null");

}
public Node reverse(Node head){
    Node prev=null;
    Node curr=head;
    while(curr!=null){
        Node next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;

    }
    return prev;
}
    
    public Node FindMiddle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
        if(head==null || head.next==null){
            return true; 
        }
        Node middle=FindMiddle(head);

    
       Node secondhalf=reverse(middle.next);
        Node firsthalf=head;
        while(secondhalf!=null){
            if(firsthalf.data != secondhalf.data){
                return false;
            }
            firsthalf=firsthalf.next;
            secondhalf=secondhalf.next;
        }  
        return true;

    }
    public static void main(String args[]){
       Palindrome ll=new Palindrome();
       ll.add(1);
       ll.add(2);
       ll.add(2);
       ll.add(4);
       ll.print(head);
       System.out.println(ll.isPalindrome());
    }
}

