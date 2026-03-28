class Solution {
    public int maxSubArray(int[] a) {
        int maxSum=a[0];
        int sum=a[0];
        for(int i=1;i<a.length;i++){
         if(sum>=0){
            sum=sum+a[i];
         }
         else{
            sum=a[i];
         }
        
         if(sum>maxSum){
            maxSum=sum;
         }
        }
         return maxSum;
    }
}
