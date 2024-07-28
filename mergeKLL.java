public class mergeKLL {
    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void print(Node node){
        Node temp=node;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

       
        public static Node makeLL(int arr[][],int rowL){

            Node newLL=new Node(0);
            Node temp=newLL;
            // Time complexity O(n*m)for makin LL and O(NlogN) for merge sort
            for(int i=0;i<rowL;i++){
                for(int j=0;j<arr[i].length;j++){
                    temp.next=new Node(arr[i][j]);
                    temp=temp.next;
                }
            }
            print(newLL.next);
            return newLL.next;
        }
        public static Node mergesort(Node head){
            if(head==null || head.next==null){
                return head;
            }
            Node mid=findmid(head);
            Node left=head;
            Node right=mid.next;
            mid.next=null;

            left=mergesort(left);
            right=mergesort(right);
            Node res=mergeBothLL(left,right);
            return res;
        }
        public static Node findmid(Node source){
            if(source==null){
                return source;
            }
            Node slow=source;
            Node fast=source.next;

            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        public static Node mergeBothLL(Node left,Node right){
            Node result=null;
            if(left==null){
                return right;
            }
             if(right==null){
                return left;
            }

                if(left.data<=right.data){
                    result=left;
                    result.next=mergeBothLL(left.next, right);
                }
                else{
                    result=right;
                    result.next=mergeBothLL(left, right.next);
                }
            return result;
    }
    // for O(N*KlogK)
    public static Node merge(Node arr[],int last){
        while(last!=0){
            int i=0,j=last;
            while(i<j){
                arr[i]=mergeBothLL(arr[i],arr[j]);
                i++;
                j--;
            }
            if(i>=j){
                last=j;
            }
        }
        return arr[0];
    }
    
    public static void main(String[] args) {
    //    int arr[][]={{1,3,5,7},
    //                {2,4,6,8},
    //             {0,9,10,11}};
    //             int rowl=arr.length;
    //             Node head=makeLL(arr, rowl);
    //             Node ans=mergesort(head);
    //             print(ans);


                int k=3,n=4;
                Node array[]=new Node[k];
                array[0]=new Node(1);
                array[0].next=new Node(3);
                array[0].next.next=new Node(5);
                array[1]=new Node(2);
                array[1].next=new Node(4);
                array[1].next.next=new Node(6);

                array[2]=new Node(0);
                array[2].next=new Node(9);
                array[2].next.next=new Node(10);
                Node h=merge(array, k-1);
                print(h);
                
    }
}
    

