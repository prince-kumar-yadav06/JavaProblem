import java.util.HashMap;

public class LLclone {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node arbit;

        Node(int data){
            this.data=data;
            this.next=next;
            this.arbit=arbit;
        }
        
    }
    public static void cloneLL(Node head,Node tail,int d){
        Node newNode=new Node(d);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }
        public static Node clone(Node head){
           Node temp=head;
           Node cloneNode=null;
           Node tailNode=null;
        //    step 1 create clone LL 
           while(temp!=null){
            cloneLL(cloneNode,tailNode,temp.data);
            temp=temp.next;
           }
        //    step 2 clone node add b/w original LL node 
          
           Node original=head;
           Node clonehead=cloneNode;
           while(original!=null && clonehead!=null){
            Node next=original.next;
            original.next=clonehead;
            original=next;

            next=clonehead.next;
            clonehead.next=original;
            clonehead=next;
           }

        //    step 3 copy arbit node 
           original=head;
           clonehead=cloneNode;
           while(original!=null && clonehead!=null){
                if(original.arbit!=null){
                    temp.next.arbit=temp.arbit.next;
                }
                else{
                    temp.next=temp.arbit;
                }
            
            clonehead=clonehead.next;
            original=original.next;
           }
        //    step 4 step2 revert change
        temp=head;
        clonehead=cloneNode;
        while(temp!=null && clonehead!=null){
            temp.next=temp.next!=null ? temp.next.next:temp.next;
            clonehead.next=clonehead.next!=null? clonehead.next.next:clonehead.next;
            temp=temp.next;
            clonehead=clonehead.next;
        }
        return cloneNode;

        }
    public static void print(Node head){
        Node temp=head;
        Node t=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
        while(t!=null){
            System.out.print(t.arbit.data+"->");
            t=t.next;
        }
    }
    public static void main(String args[]){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);

        head.arbit=head.next.next;
        head.next.arbit=head;
        head.next.next.arbit=head.next.next.next.next;
        head.next.next.next.arbit=head.next.next;
        head.next.next.next.next.arbit=head.next;

        Node h=clone(head);
        print(head);

    }
}
