
import java.util.*;
public class ReorderList{
    static Node head;
   static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    static Node middle(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
static Node reverse(Node head){
    Node curr = head;
Node prev = null;
Node nxt = null;
    
    while(curr != null){
        nxt = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nxt;
    }
    return prev;
}

public static void reorderList(Node head) {
    if(head == null || head.next == null)
        return;
    
    Node mid = middle(head);
    Node secondLL = reverse(mid.next);
    mid.next = null;
    
    Node firstLL = head;
    Node c2 = secondLL;
    Node temp1 = null;
    Node temp2 = null;
    
    while(firstLL!= null && c2 != null){
        temp1 = firstLL.next;
        temp2 = c2.next;
        
        firstLL.next = c2;
        c2.next = temp1;
        
         firstLL=temp1;
        c2 = temp2;
    }
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
    ReorderList ll=new ReorderList();
    Node head=new Node(1);
    head.next=new Node(2);
    head.next.next=new Node(3);
    head.next.next.next=new Node(4);
    head.next.next.next.next=new Node(5);
    reorderList(head);
    print(head);
}
}
    
    

