public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int cnt=0;
        int n=A.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int xor=0;
        map.put(xor,1);
        
        for(int i=0;i<n;i++){
            xor=xor^A.get(i);
            int x=xor^B;
            
            if(map.containsKey(x)){
                cnt+=map.get(x);
            }
            
            if(map.containsKey(xor)){
                map.put(xor,map.get(xor)+1);
            }else{
                map.put(xor,1);
            }
        }
        return cnt;
    }
}
