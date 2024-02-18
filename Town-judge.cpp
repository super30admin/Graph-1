// Time Complexity : O(V+E)

// Space Complexity : O(V)

// Did this code successfully run on Leetcode : YES

// Appoarch: have an adjacency list containing indegrees and outdegrees count.
// return the n-1

// 997. Find the Town Judge

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegrees(n+1);
        for(auto edge : trust){
            indegrees[edge[0]]--;
            indegrees[edge[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(indegrees[i] == n-1){
                return i;
            }
        }
        return -1;
    }
};