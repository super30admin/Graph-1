// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Maintain an indegrees array and go through the graph
// 2. If '1' follows '2', decrease value at index 1 and increase value at index 2
// 3. The town judge should follow none and be followed by n-1 people, hence return index corr to value n-1 else return -1
 
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> count(N,0);
        for (auto itr: trust){
            count[itr[0]-1]--;
            count[itr[1]-1]++;
        } 
        for (int i=0; i<N;i++)
            if(count[i] == N-1)
                return i+1;
        return -1;
    }   
};