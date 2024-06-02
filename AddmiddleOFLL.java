import java.util.*;
public class AddmiddleOFLL{
    static node head;
    class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }

    }
    public void add(int data){
        node newnode=new node(data);
        

        newnode.next=head;
        head=newnode;
    }
    public void print(){
       
        while(head!=null){
            System.out.print(head.data+"-->");
            head=head.next;
        }
        System.out.print("null");
    }
    public void addInMiddle(int idx,int data) {
        node newnode=new node(data);
        node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public static void main(String args[]){
        AddmiddleOFLL ll=new AddmiddleOFLL();
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.addInMiddle(2, 7);
        ll.print();
    }
}