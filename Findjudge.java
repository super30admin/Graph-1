/*Approach BF
 * take a Hasmap to store who's getting interest, and value as list of all people exprsssing interest for that kry
 * once done uilding
 * traverse through all key set, and if we find more than 1 key null, we return false; 
 * else we check for all the values to see, if that key had interest from all or not
 * tc:O(V+V+E)
 * sc:O(V+E)
 */
/**
 * Optimized
 * Indegrees array
 * person showing interest - --
 * person getting interest ++
 * at last traverse through array and check for the value = n-1
 * 
 * TC: O(V+E) // Max O(V,E)
 * sc: O(v)
 * 
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        // base case
        if (trust == null)
            return -1;

        int[] indegrees = new int[n + 1];

        for (int[] peeps : trust) {
            indegrees[peeps[0]]--;
            indegrees[peeps[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1)
                return i;
        }

        return -1;
    }
}