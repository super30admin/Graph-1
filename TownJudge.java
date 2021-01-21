// Time Complexity :O(V+E) 
// Space Complexity :O(V) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: Calculate the ndegree by traversing through the trust array and store 
// new array. Iterate through the new array and check for n-1 ndegree.
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==0)
            return -1;
        int[] ndegree = new int[N];
        for(int trusts[] :trust){
            ndegree[trusts[0]-1]--;
            ndegree[trusts[1]-1]++;
        }
        for(int i=0;i<N;i++){
            if(ndegree[i]==N-1)
                return i+1;
        }
            return -1;
    }
}