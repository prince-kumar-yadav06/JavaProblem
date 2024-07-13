import java.util.*;
public class FindIntersection{
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    public static Node intersection(Node head1,Node head2){
        Node secondLL=head2;
        
        while(secondLL!=null){
            Node firstLL=head1;
            while(firstLL!=null){
                if(firstLL==secondLL){
                    return secondLL;
                }
                firstLL=firstLL.next;

            }
           secondLL= secondLL.next;
        }
        return null;
    }
    
    
    public static int intersectionUsingHash(Node head1,Node head2){
        HashSet<Integer> h=new HashSet<>();
        Node secondLL=head2;
        Node firstLL=head1;
        
        while(firstLL!=null){
            h.add(firstLL.data);
            firstLL=firstLL.next;

        }
    while(secondLL!=null){
        if(h.contains(secondLL.data)){
            return secondLL.data;
        }
        secondLL=secondLL.next;  
     }
        return 0;
    }
    public static void main(String[] args) {
        Node head1=new Node(10);
        Node newnode=new Node(15);
        head1.next=newnode;
     head1.next.next=new Node(30);


     Node head2=new Node(3);
     head2.next=new Node(6);
     head2.next.next=new Node(9);
     head2.next.next.next=newnode;
     
    

    head1.next.next.next = null;
     Node res=intersection(head1, head2);


     if(res==null){
        System.out.println("no intersection");
     }
     else{
        System.out.println(res.data);
     }

     System.out.println(intersectionUsingHash(head1, head2));
    }
    
}   
