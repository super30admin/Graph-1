/*
Edges Array Traversal
Time Complexity - O(V+E)
Space Complexity - O(V) - number of nodes/ people
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class FindTownJudge_LC_997 {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1]; //We use n+1 because the people are labeled from 1 to n, not 0 to n-1. So we create an array of size n+1 and leave indegree[0] unused.
        for(int i[] :trust) {
            int a = i[0];
            int b = i[1];
            indegree[b]++;
            indegree[a]--;
        }
        for(int i = 1; i<indegree.length; i++) {
            if(indegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}