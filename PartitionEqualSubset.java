public class PartitionEqualSubset {
    

        public static boolean canPartition(int[] nums) {
             int sum = 0;
             int n = nums.length;
             
             for(int i : nums) sum+=i;
             
             if(sum%2!=0) return false;
             
             sum /= 2;
             
             // mem = new boolean[n+1][sum+1];
             
             // return subsetSum(nums,0,sum);
             boolean dp[]=new boolean[sum+1];
             dp[0]=true;
     
             for(int i : nums){
                 for(int j=sum;j>0;j--){
                     if(j>=i){
                         dp[j]=dp[j] || dp[j-i];
                     }
                 }
             }
             return dp[sum];
         }
     
     public static void main(String args[]){
        int arr[]={1,2,3,5};
        System.out.println(canPartition(arr));
     }
    }


