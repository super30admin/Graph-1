public class TownJudge {
    //TC = O(V+E) SC = O(V)
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int[] each:trust){
            indegree[each[0]-1]-=1;
            indegree[each[1]-1]+=1;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}
