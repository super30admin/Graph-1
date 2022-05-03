//TC:O(V+E) V= no. of people , E = Length of trust matrix i.e. edges in matrix
//SC:O(V+E)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n ==1) return 1;  // for the case where n= 1 and trust =[]  bcoz there is only one person and one person will trust himself
        int[] indegree = new int[n+1];  //indegress array of n+1 size with 0th index = 0 always
        for(int[] trustee : trust){
            indegree[trustee[0]]--;//decreasing the degree of the one which trusts someone
            indegree[trustee[1]]++;//increasing indegree of one who is being trusted
        }
        for(int i=0;i<n+1;i++){
            if(indegree[i]==n-1) return i;  // if any of the indegree becomes n-1 that means everyone trusts him 
        }
        return -1;
    }
}
