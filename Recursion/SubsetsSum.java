class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        solve(0,arr,ans,new ArrayList<>());
        return ans;
    }
    void solve(int index,int[] arr,ArrayList<Integer> ans,List<Integer> list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        ans.add(sum);
        
        for(int i=index;i<arr.length;i++){
            list.add(arr[i]);
            solve(i+1,arr,ans,list);
            list.remove(list.size()-1);
        }
    }
}
