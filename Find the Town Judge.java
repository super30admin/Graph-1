class Solution {
    public int findJudge(int n, int[][] trust) {

        if(n==1 && trust.length == 0) return 1;

        int[] arr = new int[n+1];

        for(int[] pair : trust)
        {
            arr[pair[0]] += -1;
            arr[pair[1]] += 1;
        }

        for(int i=0 ; i<arr.length ; i++)
        {
            if(arr[i] == (n-1)) return i;
        }

        return -1;
    }
}
