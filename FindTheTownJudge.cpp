//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


class Solution {
public:
    int findJudge(int n, vector<vector<int> >& trust) {
        vector<int> indegrees(n,0);
        
        for(auto t : trust)
        {
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        
        for(int i=0;i<indegrees.size();i++)
        {
            if(indegrees[i]==n-1)
            {
                return i+1;
            }
        }
        return -1;
    }
};