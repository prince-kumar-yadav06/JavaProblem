public class RemoveInUNsorted {
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void delete(Node tobeDel){
        if(tobeDel==null){
            return ;
        }
        tobeDel.data=tobeDel.next.data;
        tobeDel.next=tobeDel.next.next;
    }
    public static void removeDup(Node head){
        Node curr=head;
        while(curr!=null && curr.next!=null){
            Node temp=curr;
            while( temp.next!=null){
                if(curr.data==temp.next.data){
                    // Node next_next=temp.next.next;
                    // Node tobedel=temp.next;
                    // delete(tobedel);
                    // temp.next=next_next;
                    temp.next=temp.next.next;
                    System.gc();
                }
                else{
                    temp=temp.next;
                }
            }
            curr=curr.next;
        }

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
        
        Node head2 =new Node(4);
        head2.next=new Node(2);
        head2.next.next=new Node(5);  // kon sa node delete krna hai//
        head2.next.next.next=new Node(4);
        head2.next.next.next.next=new Node(2);
        head2.next.next.next.next.next=new Node(6);
        head2.next.next.next.next.next.next=new Node(6);
        print(head2);
        removeDup(head2);
        print(head2);

    }
}
