import java.util.*;
public abstract class zigzag {
    static Node head;
    static int temp=0;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    public static void rearrange(Node head){
        boolean flag=true; //if flag is true then print greater value in output else smaller
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(flag==true){
            // if situation A>B>C we get after swapping
            if(curr.data>curr.next.data){
                temp=curr.data;
                curr.data=curr.next.data;
                curr.next.data=temp;
            }
        }
            // if situation A<B<C we get after swapping
        else{
            if(curr.data<curr.next.data){
                temp=curr.data;
                curr.data=curr.next.data;
                curr.next.data=temp;
            }

        }
        curr=curr.next;
        flag=!flag;       //falg ek bar false hoga ek bar true hoga so 
                           //ek bar greater and ek bar smaller value print hoga
        }
    }
    public static void push(int new_data){
        Node new_node=new Node(new_data);
            new_node.next=head;
        
        head=new_node;
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
public static void main(String args[]){
    push(10);
    push(5);
    push(20);
    push(15);
    push(11);

    System.out.println("given linked list");
    print(head);
    rearrange(head);
    System.out.println("zigzag linked list");
    print(head);


}
}
