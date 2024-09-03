class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        set.remove(startWord);
        while(!q.isEmpty()){
            String node=q.peek().first;
            int step=q.peek().second;
            q.remove();
            if(targetWord.equals(node)) return step;
            for(int i=0;i<node.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] repl=node.toCharArray();
                    repl[i]=ch;
                    String newWord=new String(repl);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
