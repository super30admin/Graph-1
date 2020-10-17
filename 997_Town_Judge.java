    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/find-the-town-judge/
    Time Complexity for operators : o(E) .. no of edges
    Extra Space Complexity for operators : o(n) .. for array
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Creatre array of size N.
                    B) for each row in the trust matric.
                    C) increment the array for incoming edges and decrement for outgoing edges.
                    D) At the end iterate through array and if any node has value == N-1 return that (i+1)
                    E) Else return -1.
    */  

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int array[] = new int[N];
        
        for(int arr[] : trust){

            array[arr[0]-1]--;
            array[arr[1]-1]++;
        }
        
        for(int i=0;i<N;i++){
            if(array[i] == N-1)
                return i+1;
        }
        return -1;
    }
}