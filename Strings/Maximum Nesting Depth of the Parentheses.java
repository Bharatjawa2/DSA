class Solution {
    public int maxDepth(String s) {
        int count=0,max=0;
        for(char c:s.toCharArray()){
            if(c=='(') count++;
            if(c==')'){
                max=Math.max(max,count);
                count--;
            }
        }
        return max;
    }
}
