// O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegrees[] = new int [n];
        for(int trus[]:trust){
            indegrees[trus[0]-1]--;
            indegrees[trus[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(indegrees[i]==(n-1)) return i+1;
        }
        return -1;
    }
}