//https://leetcode.com/submissions/detail/649285912/
//Time: O(N)
//Space: O(1)

public class Solution {
    public int FindJudge(int n, int[][] trust) {
        
        int[] degree = new int[n + 1];
        
        foreach(int[] pair in trust) {
            
            degree[pair[0]]--;
            degree[pair[1]]++;
        }
        
        for(int i = 1; i <=n; i++) {
            
            if(degree[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}