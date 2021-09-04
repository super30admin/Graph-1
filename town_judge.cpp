// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Almost. Failing just 5/92 tests
// Any problem you faced while coding this - Not sure what seems to be the issue

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        
        set<int> tr_set;
        int i;
        
        for(i = 0; i < trust.size(); i++)
        {
            tr_set.insert(trust[i][0]);
        }
        
        if(tr_set.size() == n)
        {
            return -1;
        }
        
        for(i = 0; i < n; i++)
        {
            if(tr_set.find(i+1) == tr_set.end())
            {
                return i+1;
            }
        }
        
        return -1;
    }
};