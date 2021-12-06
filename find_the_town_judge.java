class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indegrees = new int[n];
        for(int [] t:trust){
            indegrees[t[0] -1]--;
            indegrees[t[1] -1]++;
        }
        
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == n-1){
                return i + 1;
            }
        }
        
        return -1;
    }
}

//TC: O(n + m) where m = trust list
//SC: O(n)
