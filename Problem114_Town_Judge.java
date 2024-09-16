/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class Solution {
    public int findJudge(int N, int[][] trust) {

        int[] count = new int[N+1];

        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int index=1; index <= N; index++){
            if(count[index] == N-1){
                return index;
            }
        }
        return -1;
    }
}