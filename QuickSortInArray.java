import java.util.*;
public class pk{
    public static int partion(int []arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                // swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        // swapping pivot and just previos index
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;
    }
    public static void quick(int []arr,int low,int high){
        if(low<high){
            int pidx=partion(arr,low,high);
            quick(arr, low,pidx-1);
            quick(arr,pidx+1,high);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,6,3,9,5,12,8};
        int n=arr.length;
        quick(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
