/*
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegrees = new int[N];
        
        for(int i=0; i<trust.length; i++){
            
            indegrees[trust[i][0]-1] -= 1;
            indegrees[trust[i][1]-1] += 1;
        }
        
        for(int i=0; i<N; i++){
            if(indegrees[i] == N-1){
                return i+1;
            }
        }
        
        return -1;
    }
}