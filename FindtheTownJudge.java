//Time Complexity: O(V+E)
//Space Complexity: O(V)

/*
 * here we maintain the turst by each person on another and their
 * own trust count. when we reach someone who is trusted by everyone
 * we return that person or -1 if no one is found.
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        for(int[] t: trust){
            arr[t[0]]--;
            arr[t[1]]++;
        }
        for(int i = 1; i <= n; i++){
            if(arr[i] == n-1) return i;
        }
        return -1;
    }
}