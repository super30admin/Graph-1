// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Track the trust scores using an array.
//   - For each trust relationship [a, b], decrement a's trust (they trust someone) and increment b's trust (they're trusted).
//   - The town judge will have trust score of n - 1 and trust no one (i.e., their score is exactly n - 1).


public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n + 1];

        for(int[] tr: trust) {
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }

        int count = 0;
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(indegrees[i] == n - 1) {
                answer = i;
                count++;
            }
        }

        if(count == 1) {
            return answer;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindJudge solver = new FindJudge();
        int[][] trust1 = {{1, 2}};
        System.out.println("Judge: " + solver.findJudge(2, trust1)); // Expected: 2

        int[][] trust2 = {{1, 3}, {2, 3}};
        System.out.println("Judge: " + solver.findJudge(3, trust2)); // Expected: 3

        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println("Judge: " + solver.findJudge(3, trust3)); // Expected: -1
    }
}
