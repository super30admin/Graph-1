// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// count incoming edges , judge will have n-1 incoming edges
class Solution {
    public int findJudge(int N, int[][] t) {
              
        if(N==1) return 1;
        int in[] = new int[N+1];
        for(int i = 0;i<t.length;i++) {
            in[t[i][0]]--;
            in[t[i][1]]++;
        }
        for(int i = 0;i<in.length;i++) {
            if(in[i] == N-1) {
                return i;
            }
        }
        
        return -1;
    }
}
