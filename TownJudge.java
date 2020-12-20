// Time Complexity :  O(V + E)  
// Space Complexity : O(V) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null) return 0;
        int[] indegree = new int[N + 1];
        for(int[] arr: trust){
            indegree[arr[1]] += 1;
            indegree[arr[0]] -= 1;
        }
        for(int i = 1; i <= N; i++){
            if(N - 1 == indegree[i])
                return i;
        }
        return -1;
    }
}