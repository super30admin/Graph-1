//TimeComplexity: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int []degreesArray = new int[n+1];
        
        for(int []t : trust) {
            degreesArray[t[0]] = degreesArray[t[0]]-1;
            degreesArray[t[1]] = degreesArray[t[1]]+1;
        }

        for(int i = 1; i<=n ;i++) {
            if(degreesArray[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}