class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int i:stones){
            map.put(i,new HashSet<>());
        }
        map.get(0).add(0);
        for(int i:stones){
            for(int j:map.get(i)){
                for(int k=-1;k<=1;k++){
                    int jump=j+k;
                    if(jump>0 && map.containsKey(i+jump)){
                        map.get(i+jump).add(jump);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            System.out.println("Stone " + entry.getKey() + " can be reached by " + entry.getValue()); 
        }
        if(map.get(stones[stones.length-1]).isEmpty()) return false;
        return true;
    }
}
