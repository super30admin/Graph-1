/*
tc: o(n) where n is length of trust
sc : o(n+1) : trustCount
get indegree and outdegree to determine judge
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0){
            return 1;
        }
        int [] trustCount = new int[n+1];
        for(int [] trustRel : trust){
            trustCount[trustRel[0]]--;
            trustCount[trustRel[1]]++;
        }
        for(int i=0; i<trustCount.length; i++){
            if(trustCount[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}