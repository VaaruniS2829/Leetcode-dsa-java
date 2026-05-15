class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int x:nums){
            h.put(x,h.getOrDefault(x,0)+1);
        }
        for(int x:nums){
            if(h.get(x)==1){
                return x;
            }
        }
        return -1;
    }
}
