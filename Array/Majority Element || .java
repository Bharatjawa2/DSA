// Understand if you want frequency ARRay and Negative numbers are there use this technique (max-min+1); , num-min , num+min;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length/3;
        int max = nums[0];
        int min = nums[0];
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int freq[] = new int[max-min+1];
        for(int num:nums){
            freq[num-min]++;
        }
        for(int i=0;i<max-min+1;i++){
            if(freq[i]>n){
                list.add(i+min);
            }
        }
        return list;
    }
}
