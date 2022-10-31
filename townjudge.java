//Tc O(N) 
//Sc O(N)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int res[] = new int[n];
        for(int i = 0;i<trust.length;i++){
            res[trust[i][1] - 1]++;
            res[trust[i][0] - 1]--;
        }
        for(int i = 0;i<res.length;i++){
            if(res[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}