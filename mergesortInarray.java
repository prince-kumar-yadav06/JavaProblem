public class mergeInarray {
    public static void conquer(int arr[],int si,int mid,int ei){
        int []merge=new int[ei-si+1];

        int idx=si;
        int idx2=mid+1;
        int k=0;
        while(idx<=mid && idx2<=ei){
            if(arr[idx]<=arr[idx2]){
                merge[k]=arr[idx];
                idx++;
                k++;
            }
            else{
                merge[k]=arr[idx2];
                idx2++;
                k++;
            }
        }
        while(idx<=mid){
            merge[k]=arr[idx];
            idx++;
            k++;
        }
        while(idx2<=ei){
            merge[k]=arr[idx2];
            idx2++;
            k++;
        }
        for(int i=0,j=si;i<merge.length;i++,j++){
            arr[j]=merge[i];
        }
    }
    public static void merge(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=(si+(ei-si)/2);
        merge(arr, si, mid);
        merge(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        int arr[]={3,7,2,9,1};
        merge(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
