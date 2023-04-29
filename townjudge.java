class Solution {
    public int findJudge(int n, int[][] trust) {
        //TC-O(V+E),SC-O(n)
        // create a graph with entries of trust as edges and track count of incoming edges increase by 1 for every incming edge and decrease one for utgoing array.If any count=n-1,that is the answer
        int[] indegrees = new int[n];
        for(int[] tr:trust){
            indegrees[tr[0]-1]--;
            indegrees[tr[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(indegrees[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}