public class sortingInLL{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;

        }
    }
    public static void sort(Node list){
        int count0=0;
        int count1=0;
        int count2=0;
        if(list==null){
            return ;
        }
    Node curr=list; 
    while(curr!=null){
        if(curr.data==0){
            count0++;
        }
       else if(curr.data==1){
            count1++;
        }
        else if(curr.data==2){
            count2++;
        }
        curr=curr.next;
        }
        curr=list;
        while(curr!=null){
            if(count0!=0){
                curr.data=0;
                count0--;
            }
            else if(count1!=0){
                curr.data=1;
                count1--;
            }
           else if(count2!=0){
                curr.data=2;
                count2--;
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
        
        Node head2 =new Node(1);
        head2.next=new Node(1);
        head2.next.next=new Node(2);  // kon sa node delete krna hai//
        head2.next.next.next=new Node(0);
        head2.next.next.next.next=new Node(2);
        head2.next.next.next.next.next=new Node(0);
        print(head2);
        sort(head2);
        print(head2);

    }
}

