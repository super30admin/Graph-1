// Time Complexity : O(n +e) where v is the number of people and e is the number of connections
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Creating an array to track the trust score for each person.
 * Going over the trust matrix to increase the trust counter for trust receiever since everyone trusts the judge.
 * Going over the trust matrix to decrease the trust counter for trust giver since the judge doesn't trust anyone.
 *
 * If the person's trust count is equals to n-1, then it means that everyone trusts the judge but the judge doesn't trust everyone.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] memo = new int[n + 1];
        for (int[] item : trust) {
            // reducing the count for the trust giver
            memo[item[0]]--;
            // increasing the count for the trust receiver
            memo[item[1]]++;
        }

        // going over all people
        // starting from 1 since people are marked with 1 to n
        for (int i = 1; i <= n; i++) {
            // if everyone else trusts, then the person trusts town judge
            // doing greater equals check if the
                return i;
        }

        // no town judge
        return -1;
    }
}