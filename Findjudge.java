// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Convert trust array to graph. Node with 0 outgoing and N-1 incoming edges is the judge node.
    public int findJudge(int n, int[][] trust) {
        
        if(n==0) return -1;
        
        int[] indegrees=new int[n];
        
        for(int[] edge:trust){
            indegrees[edge[0]-1]--;
            indegrees[edge[1]-1]++;
        }
        
        for(int i=0;i<indegrees.length;i++){

            if(indegrees[i]==(n-1))
                return i+1;
        }
        
        return -1;
    
    }
}