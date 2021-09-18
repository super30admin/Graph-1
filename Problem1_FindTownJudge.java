/*
Time complexity: O(N) ; we need to traverse the given trust [N = m+n]
Space Complexity: O(N) ; we use array of length N
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        //Base
        if(trust.length==0 && n==1){
            return 1;
        }
        int m = trust.length;
        int[] indegrees = new int[n+1];
        int[] outdegrees = new int[n+1];
        // System.out.println("Length of both arrays: "+indegrees.length);
        
        // List<Integer> indegrees = new List<>(m); //Else only Degrees
        for(int[] t : trust ){
            // for(int j = 0; j<n ; j++){
            // System.out.print(t[0] + " trusts "+ t[1]);
            // outdegrees[t[0]]++;
            indegrees[t[1]]++;
            // System.out.println(indegrees+ " " + outdegrees);
            // }
        }
        
        for(int j = 0; j<indegrees.length ; j++){
            indegrees[j] = indegrees[j] - outdegrees[j];
        }
        for(int j = 0; j<indegrees.length ; j++){
            if(indegrees[j] == n-1) return j;
        }
        return -1;
    }
}
