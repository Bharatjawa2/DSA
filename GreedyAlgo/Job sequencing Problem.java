class Job{
    int profit;
    int deadline;
    Job(int profit,int deadline){
        this.profit=profit;
        this.deadline=deadline;
    }
}
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n=deadline.length;
        Job[] job=new Job[n];
        
        for(int i=0;i<n;i++){
            job[i]=new Job(profit[i],deadline[i]);
        }
        
        Arrays.sort(job,(a,b)->b.profit-a.profit);
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,job[i].deadline);
        }
        
        boolean[] vis=new boolean[max+1];
        int sum=0;
        
        for(Job i:job){
            for(int j=i.deadline;j>0;j--){
                if(!vis[j]){
                    count++;
                    vis[j]=true;
                    sum+=i.profit;
                    break;
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(count);
        ans.add(sum);
        return ans;
    }
}
