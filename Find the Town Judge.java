//Time Complexity : O(V+E)
//sPACE cOMPLEXITY : O(V)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust==null || n==0){
            return -1;
        }
        //find the indegree of each node.ie how many ppl trust foe each person
        int[] indegree = new int[n];
        for(int[] t : trust){
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }
        //the person with indegree  of n-1 will be the judge
        for(int i=0;i<n;i++){
            if(indegree[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}