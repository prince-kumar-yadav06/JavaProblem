import java.util.*;
public class arbitrary{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node arbit;

        Node(int data){
            this.data=data;
            this.next=null;
            this.arbit=null;
        }
    }
        public static void print(Node node,Node anode){
            Node temp=node;
            System.out.println(("Traversal using Next Pointer"));
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println("\nTraversal using Next arbit Pointer");
            while(anode!=null){
                System.out.print(anode.data+" ");
                anode=anode.arbit;
            }
        }
        public static Node add(Node start){
            Node temp=start;
            while(temp!=null){
                temp.arbit=temp.next;
                temp=temp.next;
            }
            return mergesort(start);
        }
        public static Node mergesort(Node head){
            if(head==null || head.arbit==null){
                return head;
            }
            Node mid=findmid(head);
            Node left=head;
            Node right=mid.arbit;
            mid.arbit=null;

            left=mergesort(left);
            right=mergesort(right);
            Node ans=mergeBothLL(left,right);
            return ans;
        }
        public static Node findmid(Node source){
            if(source==null){
                return source;
            }
            Node slow=source;
            Node fast=source.arbit;

            while(fast.arbit!=null){
                slow=slow.arbit;
                fast=fast.arbit.arbit;
            }
            return slow;
        }
        public static Node mergeBothLL(Node left,Node right){
            Node result=null;
            if(left==null){
                return right;
            }
            else if(right==null){
                return left;
            }
            if(left.data<=right.data){
                result=left;
                result.arbit=mergeBothLL(left.arbit, right);

            }
            else{
                result=right;
                result.arbit=mergeBothLL(left, right.arbit);
            }
            return result;
        }
        public static void main(String[] args) {
            // arbitrary list=new arbitrary();
           Node head=new Node(5);
            head.next=new Node(10);
            head.next.next=new Node(2);
            head.next.next.next=new Node(3);
         Node  ahead= add(head);
           print(head,ahead);
        }
    }

