/*Running Time Complexity: O(n)
Space Complexity: O(n)
Sucessfully Run and Compiled on leetcode
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int i =0;i<trust.length;i++){
            indegree[trust[i][1]-1]++;
            indegree[trust[i][0]-1]--;
            
        }
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==n-1) return i+1;
        }
        
        return -1;
    }
}