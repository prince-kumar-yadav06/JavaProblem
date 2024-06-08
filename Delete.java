public class Delete{
    static Node head;
   static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    
    public static void deleteDuplicate(Node list){
        // base case
        if(list ==null){
            return ;
        }
        Node curr=list;
        while(curr.next!=null){
            if(curr.data==curr.next.data){
              curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
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
        
        Node head2 =new Node(1);
        head2.next=new Node(2);
        head2.next.next=new Node(3);  // kon sa node delete krna hai//
        head2.next.next.next=new Node(3);
        head2.next.next.next.next=new Node(3);
        head2.next.next.next.next.next=new Node(4);
        head2.next.next.next.next.next.next=new Node(4);
        print(head2);
        deleteDuplicate(head2);

        print(head2);

    }
}
