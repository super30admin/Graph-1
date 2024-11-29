class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg= new int[n];
        for(int i=0;i<trust.length;i++){
            indeg[trust[i][0]-1]--;
            indeg[trust[i][1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}
