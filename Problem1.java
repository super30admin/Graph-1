/*
Town Judge
approach: take indegrees array
time: O(n+len(trust))
space: O(n)
 */
public class Problem1 {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n];

        for(int i=0;i<trust.length;i++) {
            trusted[trust[i][0]-1]--;
            trusted[trust[i][1]-1]++;
        }

        for(int i=0;i<n;i++) {
            if(trusted[i]==n-1) return i+1;
        }

        return -1;
    }
}