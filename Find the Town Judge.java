class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        for(int[] elem : trust){
            arr[elem[0]-1]--;
            arr[elem[1]-1]++;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n-1) return i+1;
        } 

        return -1;
    }
}
