import java.util.ArrayList;
import java.util.*;
public class flattenLL {
    static Node head;
    static class Node{
        int data;
        Node child;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
            this.child=null;
        }
    }
    public static Node merge(Node a,Node b){
        Node ans=new Node(-1);
        Node temp=ans;

        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.child=a;
                temp=a;
                a=a.child;
            }
            else{
                temp.child=b;
                temp=b;
                b=b.child;
            }
            temp.next=null;
        }
        if(a!=null){
            temp.child=a;
        }
        else{
            temp.child=b;
        }

        if(ans.child!=null){
            ans.child.next=null;
        }
        return ans.child;
    }
    // Optimal solution 
    // Time Complexity=O(N*(2M))~O(2N*M) N=length by next pointer and M by child pointer
    //N for travesing N next pointer And M=merging child take 2M bqcz 2 child is traversing
    public static Node flatten(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mergedhead=flatten(head.next);
        head=merge(head,mergedhead);
        return head;

    }
    public static void print(Node head){
        Node temp=head;

        while (temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.child;
            } 
    }
    public static void printoriginalLinkedlist(Node head){
        Node temp=head;
        while(temp!=null){
            Node t2=temp;
            while(t2!=null){
                System.out.print(t2.data+"->");
                t2=t2.child;
            }
            System.out.println();
            temp=temp.next;
        }
    }
            
        // Brute force 
        public static Node flattenUsingArrayList(Node head){
            ArrayList<Integer> arr =new ArrayList<>();
            Node temp=head;
            while(temp!=null){
                Node t2=temp;
                while(t2!=null){
                    arr.add(t2.data);
                    t2=t2.child;
                }
                temp=temp.next;
            }
            Collections.sort(arr);
            Node ans=convertArrTOLL(arr);
            return ans;
        }
        public static Node convertArrTOLL(ArrayList<Integer> arr){
            Node dummyNode=new Node(-1);
            Node temp=dummyNode;
            for(int j=0;j<arr.size();j++){
                temp.child=new Node(arr.get(j));
                temp=temp.child;
            }
           return dummyNode.child;
        }
    
    public static void main(String args[]){

        Node head=new Node(1);
        head.child=new Node(6);

        head.next=new Node(2);
        head.next.child=new Node(7);
        head.next.child.child=new Node(9);


        head.next.next=new Node(8);
        head.next.next.child=new Node(12);

     //optimal solution
     
        printoriginalLinkedlist(head);
        Node h=flatten(head);
        System.out.println("after flatten");
        print(h);

        // Brute force 
        // System.out.println("Ussing Brute force");
        // System.out.println("Before flatten");
        // printoriginalLinkedlist(head);
        // System.out.println("after flatten");
        // Node h2=flattenUsingArrayList(head);
        // print(h2);
    }
}
