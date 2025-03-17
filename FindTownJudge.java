/*
 * TC: O(n)
 * SC: O(n)
 */
public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        for(int[] t: trust) {
            // if they trust someone, decrement their count
            trustCount[t[0]]--;
            // if they are trusted by someone, increment their count
            trustCount[t[1]]++;
        }
        //finally, the judge will have count n - 1 as they are trusted by everyone else
        //but they trust noone
        for(int i = 1; i <= n; i++) {
            if(trustCount[i] == n - 1) return i;
        }
        //if nobody with that count exists, return -1
        return -1;
    }
}
