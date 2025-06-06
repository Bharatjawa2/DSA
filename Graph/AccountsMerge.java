class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x==y) return;
        if(rank[x]<rank[y]) parent[x]=y;
        else if(rank[x]>rank[y]) parent[y]=x;
        else{
            parent[y]=x;
            rank[x]++;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    ds.union(i,map.get(mail));
                }
            }
        }

        List<String>[] mails=new ArrayList[n];
        for(int i=0;i<n;i++){
            mails[i]=new ArrayList<>();
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String mail=entry.getKey();
            int parent=ds.find(entry.getValue());
            mails[parent].add(mail);
        }

        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mails[i].size()==0) continue;
            Collections.sort(mails[i]);
            List<String> l=new ArrayList<>();
            l.add(accounts.get(i).get(0));
            for(String s:mails[i]) l.add(s);
            ans.add(l);
        }
        return ans;
    }
}
