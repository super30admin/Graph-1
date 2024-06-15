// TC: O(E+V)
// S: O(V)
// Approach - maintaining in and out array
// Increment value if they receive trust and decrement if they give trust
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];

        for(int[] tr : trust){
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }

        for(int i=1;i<= n;i++){
            // whoever trust equals to n-1
            if(indegrees[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}