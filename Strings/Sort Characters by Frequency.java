class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->Integer.compare(freq[b],freq[a]));
        for(int i=0;i<256;i++){
            if(freq[i]>0){
                pq.add((char)i);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            int count=freq[c];
            while(count-->0) sb.append(c);
        }
        return sb.toString();
    }
}
