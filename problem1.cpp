// Time Complexity : O(E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int>In(n+1,0);
        for(auto & p: trust)
        {
            In[p[0]]--;
            In[p[1]]++;
        }
        for(int i = 1;i<=n;i++)
        {
            if(In[i]==n-1) return i;
        }
        return -1;
    }
};