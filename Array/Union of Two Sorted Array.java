class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        Integer last=null;
        
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                if(last==null || last!=a[i]){
                    ans.add(a[i]);
                    last=a[i];
                }
                i++;
                j++;
            }
            else if(a[i]>b[j]){
                if(last==null || last!=b[j]){
                    ans.add(b[j]);
                    last=b[j];
                }
                j++;
            }else{
                if(last==null || last!=a[i]){
                    ans.add(a[i]);
                    last=a[i];
                }
                i++;
            }
        }
        for(int k=i;k<a.length;k++){
            if(last==null || last!=a[k]){
                ans.add(a[k]);
                last=a[k];
            }
        }
        for(int k=j;k<b.length;k++){
            if(last==null || last!=b[k]){
                ans.add(b[k]);
                last=b[k];
            }
        }
        return ans;
    }
}
