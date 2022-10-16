/*
## Problem 1: Find Judge (https://leetcode.com/problems/find-the-town-judge/)

Time Complexity :   O (V + E) 
Space Complexity :  O (V) 
Did this code successfully run on Leetcode :    Yes (997. Find the Town Judge)
Any problem you faced while coding this :       No
 */
// Input: n = 2, trust = [[1,2]]
// Output: 2

class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n];
        
        for(int[] trusts: trust){
            inDegrees[trusts[0] - 1]--;
            inDegrees[trusts[1] - 1]++;
        }
        // only the town judge has inDegree n-1
        for(int i=0; i<inDegrees.length; i++){
            if(inDegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}
