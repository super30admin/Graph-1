//time o(n)
//space o(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }
        
        int[] trustArr = new int[n+1];
                
        for(int[] arr : trust) {
            trustArr[arr[0]] = trustArr[arr[0]]-1;
            trustArr[arr[1]] = trustArr[arr[1]]+1;
        }
        
        for(int i=1; i<trustArr.length; i++) {
            if(trustArr[i] == n-1)
                return i;
        }
        
        return -1;
        
    }
}
