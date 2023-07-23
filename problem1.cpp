/*
// Time Complexity : O(M+N) length of the trust + number of nodes
// Space Complexity : O(N) lenght of the nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/


#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> res(n,0);
        size_t m = trust.size();
        for(size_t i{};i<m;++i){
            res.at(trust.at(i).at(0)-1)--;
            res.at(trust.at(i).at(1)-1)++;
        }
        for(size_t i{};i<n;++i){
            if(res.at(i) == n-1){
                return i+1;
            }
        }
        return -1;
    }
};