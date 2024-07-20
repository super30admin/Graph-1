public class TownJudge {
    /*
     * brute force -
     * // go over the trust array check if each member is prsesent
     * //at the second index and increment the count. whichever memebr is at second
     * index
     * //for n number of times and at the same time that memeber is not at the first
     * index,
     * //thats a town judge. mXn - m is number of trust relationsi nthe trust array
     */

    /**
     * optimized Solution.
     * Use indegree array. in indegree array each index represents the person in
     * town.
     * length is n. but my array is zero indexed. so each person is represented by
     * -1
     * iterate through trust :
     * every first index shows outdegree -1
     * every second index shows Indegree +1
     * at every index, add +1 if indegree, and -1 if out degree.
     * after done traversing, find the index that has 4 value because n=5,
     * which means 5 people so 4 indegree. Retuen index+1 as array is zero indexed.
     *  // Time complexity - O(v+E)
     *  //space complexity - O(V)
     */

    public int findJudge(int n, int[][] trust) {
        if (n == 0) {
            return -1;
        }
        // indegree array
        int[] indegrees = new int[n];

        for (int[] t : trust) {
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;

    }
}
