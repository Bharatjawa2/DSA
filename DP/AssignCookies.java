class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int c=0;
        int i=0,j=0;

        while(i<n && j<m){
            if(s[j]>=g[i]){
                c++;
                j++;
                i++;
            }else{
                j++;
            }
        }
        return c;
    }
}
