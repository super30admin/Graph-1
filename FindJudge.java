//TC - O(V + E) where V is the number of people and E is the relationships given to us
//SC - O(V) - an array called indegrees whose size is equal to the number of people.
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0){
            return -1;
        }
        int[] indegrees = new int[n + 1];
        for(int[] t : trust){
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for(int i = 0; i < n; i++){
            if(indegrees[i] == n - 1){
                return i + 1;
            }
        }
        return -1;
    }
}