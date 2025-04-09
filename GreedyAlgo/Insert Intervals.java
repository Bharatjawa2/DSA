public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        int l = newInterval[0];
        int r = newInterval[1];
        while (i < n && r >= intervals[i][0]) {
            r = Math.max(r, intervals[i][1]);
            l = Math.min(l, intervals[i][0]);
            i++;
        }
        ans.add(new int[]{l, r});
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
