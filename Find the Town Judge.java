//  Time Complexity: O(E + V)
//  Space Complexity: O(V)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int totalTrust[] = new int[n];
        for(int i = 0; i< trust.length; i++){
            totalTrust[trust[i][0]-1]--;
            totalTrust[trust[i][1]-1]++;
        
        }
        for(int i = 0; i< n; i++){
            if(totalTrust[i] == n-1) return i+1;
        }
        return -1;
    }
}