class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (!rankMap.containsKey(sortedArr[i])) {
                rankMap.put(sortedArr[i], rank);
                rank++;
            }
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}
