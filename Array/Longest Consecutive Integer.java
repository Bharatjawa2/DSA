class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);

        int max=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int length=1;
                while(set.contains(num+length)){
                    length++;
                }
                max=Math.max(max,length);
            }
        }
        return max;
    }
    
}
