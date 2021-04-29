class Solution {
    public int findJudge(int N, int[][] trust) {
        //creating an indgree and outdegrre matrices
        int[] indegree = new int[N];
        int[] outdegree = new int[N];
        
        //incrementing the count of indgree and out degree matrices
        for(int[] arr: trust){
            outdegree[arr[0] - 1]++;
            indegree[arr[1] - 1]++;
        }
        
        //Checking if the judge condition satiefies or not
        for(int i = 0; i < N; i++){
            if(indegree[i] == N-1 && outdegree[i] == 0){
                return i+1;
            }
        }
        
        return -1;
    }
}

//Time Complexity: O(max(N , m)) m -> size of trust matrix 
// Space Complexity: O(2N)