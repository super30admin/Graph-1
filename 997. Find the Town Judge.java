class Solution {// Time of O(N + E) and space of O(N)
    public int findJudge(int N, int[][] trust) {
        int[] relations = new int[N + 1];
        
        for(int[] edge: trust){
            //Incoming edge
            relations[edge[1]]++;
            //Outgoing edge
            relations[edge[0]]--;
        }
        //Which one has N-1 incoming edge
        
        for(int i = 1; i< relations.length ; i++){
            if(relations[i] == N-1)
                return i;
        }
        return -1;
    }
}