/*
The time complexity is O(N) and the space complexity is O(N).

Here the intuition is find a number where the incount- people who trust him should be N-1 and outcount- people whom he trust should be 0.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int findJudge(int N, int[][] trust) {

        // Array to store each number's incount.
        int[] incount = new int[N+1];

        //Array to store each number's outcount.
        int[] outcount = new int[N+1];
        for(int[] arr:trust){
            incount[arr[1]]++;
            outcount[arr[0]]++;
        }

        //Check the condition.
        for(int i=1;i<N+1;i++){
            if(incount[i]==N-1){
                if(outcount[i]==0){
                    return i;
                }
            }
        }

        return -1;
    }
}