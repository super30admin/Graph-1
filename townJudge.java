class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] indegrees = new int[N];
        //For every input, we decrement the count for trust giving person and increment the count for trust taking person
        for(int[] input:trust){
            indegrees[input[0] - 1]--;
            indegrees[input[1] -1]++;
        }
        for(int i =0;i<N;i++){
            if(indegrees[i] == N-1)
                return i+1;
        }
        return -1;
    }
}

//Time Complexity: O (V+E)
//Space Complexity: O(V)
