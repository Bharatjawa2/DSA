class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        int ind=-1;
        for(int i=n-1;i>=0;i--){
            if(Integer.valueOf(num.charAt(i))%2!=0){
                ind=i;
                break;
            }
        }
        return ind==-1 ? "":num.substring(0,ind+1);
    }
}
