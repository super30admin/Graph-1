// Time O(n)
// Space: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n-1) {
            return -1;
        }
        int[] store = new int[n+1];
        for(int[] each : trust){
            store[each[1]]++;
            store[each[0]]--;
        }

        for(int i=1; i< store.length;i++){
            if(store[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}