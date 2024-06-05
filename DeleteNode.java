public class DeleteNode{
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
    
    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        
        Node head2 =new Node(2);
        head2.next=new Node(3);
        head2.next.next=new Node(5);  // kon sa node delete krna hai//
        head2.next.next.next=new Node(7);
        print(head2);
        delete(head2.next.next);

        // delet(2,4);
        print(head2);

    }
}
