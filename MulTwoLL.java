public class MulTwoLL{
   static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    public static int MultiplyTwoLL(Node First,Node second){
        int n1=0; int n2=0;
        Node f=First;
        Node s=second;
        while(f!=null || s!=null){
            if(f!=null){
                n1=(n1*10)+f.data;
                f=f.next;
            }
            if(s!=null){
                n2=(n2*10)+s.data;
                s=s.next;
            }
        }
        return n1*n2;
        
    }
    public static void print(Node head){
        Node temp=head;
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
        Node first=new Node(1);
        first.next=new Node(2);
        first.next.next=new Node(3);

        print(first);

        Node second=new Node(5);
        second.next=new Node(4);
        print(second);
        System.out.println(MultiplyTwoLL(first,second));
    }
}