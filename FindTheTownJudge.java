/**
 * Time Complexity: O(E)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Using a single indegrees, we can keep a count of how many people trust one person based on trusts[]
 *  and reduce the count on people who trust other person. Eventually the town judge should be trusted by (N-1) people (because he cannot judge himself)
 * and return that value in 1-indexed indegrees array
 */

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }
        
        int result = -1;
        int[] indegrees = new int[n + 1];
        for (int[] t: trust) {
            indegrees[t[0]]--;
            indegrees[t[1]]++;
        }
        
        for (int i = 1; i <= n;i++) {
            if (indegrees[i] == n - 1)
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Your code here
        FindTheTownJudge obj = new FindTheTownJudge();
        int value = obj.findJudge(4, new int[][] {{1,2}, {2, 3}, {1,3}, {4, 3}});
        System.out.println(value);
        assert (value == 3);
    }
}