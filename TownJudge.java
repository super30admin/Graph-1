//looks like courses taken in semester graph question indegrees array needed

// Approach
// Since judge doesnt trust anyone the outdegree must be 0 and since everyone trusts him,
// there is a directed edge towards judge from each and every node(N-1). Hence, we count the
// indegree for each of the nodes and the node with indegree = N-1 is town judge

class Solution {
    public int findJudge(int N, int[][] trust) { //Celebrity problem
       // if(trust == null || trust.length == 0 ) return 0; because for node 1 with trust array empty town judge is 1 
        if(trust == null ) return 0;
       
        int[] indegrees = new int[N]; // N is persons
       
        for(int[] t : trust){
    // t[0] is person 1,t[N-1] is person N  Hence t[0]-1 denoted person 1 in indegrees array starting from 0
           //Indegrees array starts with 0  
           indegrees[t[0]-1]--; //trust giver
            indegrees[t[1]-1]++;
        }
       
        for(int i = 0 ; i < indegrees.length;i++){
            if(indegrees[i] == N-1){
                return i+1; // person in indegrees array +1
            }
        }
        return -1;
    }
}

/*
Time complexity: O(m+n)
Space complexity: O(n)
*/