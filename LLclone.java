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
        public static Node clone(Node head){
            HashMap<Node,Node> map=new HashMap<>();
            Node temp=head;
            Node clone=temp;

            while(temp!=null){
                clone=temp;
                map.put(temp,clone);
                temp=temp.next;

            }
            temp=head;
            clone=temp;
            while(temp.next!=null){
                map.get(clone).arbit=map.get(temp).arbit;
                temp=temp.next;
            }
            return map.get(head);
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
