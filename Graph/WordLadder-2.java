
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> arr = q.poll();
            if (arr.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    set.remove(it);
                }
            }
            String word = arr.get(arr.size() - 1);
            if (word.equals(endWord)) {
                if (ans.isEmpty()) ans.add(new ArrayList<>(arr));
                else if (ans.get(0).size() == arr.size()) ans.add(new ArrayList<>(arr));
            }
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] repl = word.toCharArray();
                    repl[i] = c;
                    String newWord = new String(repl);
                    if (set.contains(newWord)) {
                        arr.add(newWord);
                        q.add(new ArrayList<>(arr));
                        usedOnLevel.add(newWord);
                        arr.remove(arr.size() - 1);
                    }
                }
            }
        }
        return ans.stream().map(ArrayList::new).collect(Collectors.toList());
    }
}
