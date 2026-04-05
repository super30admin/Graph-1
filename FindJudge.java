// Time Complexity : O(E), number of trust relationships (edges)
// Space Complexity : O(N) , number of people
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We maintain a scores array to keep track of relationship scores for each person. We iterate through the trust
relationships which is array of edges and decrement the score for person who is trusting i.e,x and increment
the score for person who is getting trusted, i.e., y. Lastly, we go through the scores array and check if any
person is trusted by all n-1 people, if so, we return that person's label. If not, -1.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] scores = new int[n + 1];

        for(int[] relation : trust) {
            scores[relation[0]]--;
            scores[relation[1]]++;
        }

        for(int i = 1 ; i <= n ; i++) {
            if(scores[i] == n - 1)
                return i;
        }
        return -1;
    }
}