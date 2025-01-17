class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int n=s.length();
        int max=Integer.MIN_VALUE;
        Set<Character> set=new HashSet<>();

        while(right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max=Math.max(max,right-left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max==Integer.MIN_VALUE ? 0:max;
    }
}
