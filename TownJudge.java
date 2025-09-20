// This solution uses an indegree array which will track inward and outward edges to an element. 
// For all the inward edges, we increment and outward we decrement
// At the end, if there is any edge with n-1 val then its the judge
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        Arrays.fill(indegree, 0);
        for(int i=0;i<trust.length;i++) {
            int[] temp = trust[i];
            indegree[temp[1]-1]++;
            indegree[temp[0]-1]--;
        }
        for(int i=0;i<n;i++) {
            if(indegree[i]==n-1) {
                return i+1;
            }
        }
        return -1;
    }
}
