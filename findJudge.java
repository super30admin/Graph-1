//Time Complexity : O(n) n is N
//Space Complexity : O(n)
// Leetcode : worked

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null) return -1;
        int[] arr = new int[N];
        for(int[] a : trust){
            arr[a[0]-1] -= 1;
            arr[a[1]-1] += 1;
        }
        
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i] == N-1) return i+1;
        }
        
        return -1;
    }
}