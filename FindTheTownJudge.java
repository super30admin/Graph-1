package Graph1;

public class FindTheTownJudge {
    /* Created by palak on 8/24/2021 */

    /**
     Time Complexity: O(n)
     Space Complexity: O(n)
     */
    public int findJudge(int n, int[][] trusts) {
        int[] indegrees = new int[n];

        for(int[] trust: trusts) {
            //Someone giving the trust
            indegrees[trust[0] - 1]--;
            //Someone getting the trust
            indegrees[trust[1] - 1]++;
        }
        for(int i = 0 ; i < indegrees.length ; i++) {
            if(indegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
