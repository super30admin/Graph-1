//time - O(n)
//space - O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0) return -1;
        int[] in = new int[n+1];
        int[] out = new int[n+1];

        for(int[] arr : trust){
            int outIdx = arr[0];
            int inIdx = arr[1];
            in[inIdx]++;
            out[outIdx]++;
        }

        for(int i=1; i<n+1; i++){
            if(in[i]==n-1 && out[i]==0)
                return i;
        }

        return -1;
    }
}
