class FindJudge {
  
    /*
        Time : O(Max(V + E)) | max between number of vertices and Edges
        Space : O(V) | number of verticies (stored in degrees array)
        Leetcode : YES
        
     */
     
     /*
        Approach :
        1. For each out degree decrease trust count by 1;
        2. For each in degree increase trust count by 1;
        3. At the end check if trust (count == Number of Vertices - 1) if so return that vertices.
     */
    public int findJudge(int N, int[][] trust) {
        if(trust == null) return -1;
        
        int[] degrees = new int[N];
        
        for(int[] t : trust){
            
            degrees[t[0] - 1]--;
            degrees[t[1] - 1]++;
        }
        
        for(int i =0; i < degrees.length; i++){
            if((degrees[i]) == N - 1)
                return i + 1;
        }
        
        return -1;
    }
}
