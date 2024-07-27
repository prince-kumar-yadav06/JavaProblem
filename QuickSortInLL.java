
public class quicksortLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static  Node partion(Node start,Node end){
        int pivot=end.data;
        Node pivotNode=start;
        Node curr=start;

        while(start!=null){
            if(start.data<pivot){
               
                pivotNode = curr; 
				int temp = curr.data; 
				curr.data = start.data; 
				start.data = temp; 
				curr = curr.next; 
			} 
            
          start=start.next;
          
        }
          
          int temp = curr.data; 
          curr.data = pivot; 
          end.data = temp; 
          
          return pivotNode;
    }
    public static void quick(Node start,Node end){
        if(start==null || end==null || start==end || start==end.next){
            return ;
        }
        Node idx=partion(start, end);
        quick(start, idx);

        if(idx!=null && idx==start){
            quick(idx.next,end);
        }
        else if(idx!=null && idx.next!=null ){
            quick(idx.next.next,end);
        }
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
    public static void main(String[] args) {
        Node head=new Node(6);
        head.next=new Node(3);
        head.next.next=new Node(9);
        head.next.next.next=new Node(5);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(8);
        Node c=head;
        while(c.next!=null)
            c=c.next;
        
        print(head);

        quick(head, c);
        print(head);
    }
}
