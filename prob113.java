// S30 Big N Problem #113 {Easy}
// 997. Find the Town Judge
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int N, int[][] trust) {
        int [] array=new int[N];
        for(int [] t: trust){
            array[t[0]-1]--;
            array[t[1]-1]++;
        }
        
        for(int i=0;i<N;i++){
            if(array[i]==N-1) return i+1;
        }
        return -1;
    }
}