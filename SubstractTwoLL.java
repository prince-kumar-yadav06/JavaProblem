public class substract
{
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static int getsize(Node head){
        int size=0;
        while(head!=null){
            size++;
            head=head.next;
        }
        return size;
    }
    public static Node revlist(Node list){
        Node prev=null;
        Node curr=list;
        Node nextNode=null;

        while(curr!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public static Node solution(Node list1,Node list2){
        Node temp1=list1;
        Node temp2=list2;

        int sum1=0;
        int sum2=0;

        int n1=getsize(list1);
        int n2=getsize(list2);
        
        while(temp1!=null){
            int val=temp1.data;
            sum1=sum1*10+val;
            temp1=temp1.next;
        }
        while(temp2!=null){
            int val=temp2.data;
            sum2=sum2*10+val;
            temp2=temp2.next;
        }

        int diff=0;
        diff=Math.abs(sum1-sum2);

        Node ans=new Node(0);
        Node newNode=ans;

       while(diff>0){
           int last=diff%10;
           diff=diff/10;
        newNode.next=new Node(last);
        newNode=newNode.next;
       }

       int maxLen=Math.max(n1,n2);
    Node revl=revlist(ans.next);
    int revListlen=getsize(revl);

    int reqzero=maxLen-revListlen;

    while(reqzero!=0){
        Node nNode=new Node(0);
        newNode.next=revl;
        revl=nNode;
        reqzero--;
    }

       return revl;
    }

    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node list1=new Node(1);
        list1.next=new Node(2);
        list1.next.next=new Node(3);
        list1.next.next.next=new Node(4);

        Node list2=new Node(3);
        list2.next=new Node(2);
        list2.next.next=new Node(1);
        list2.next.next.next=new Node(6);

        print(list1);
        print(list2);
        Node sub=solution(list1,list2);
        print(sub);
    }
}
