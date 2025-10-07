#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use an array to count trust levels: losing trust (out-degree) subtracts, gaining trust (in-degree) adds.
The town judge should be trusted by everyone else but trust no one.
So we just find the person with an in-degree of n−1.
*/
class Solution{
public:
    int findJudge(int n, vector<vector<int>>& trust){
        vector<int> inDegrees(n+1);

        for(auto& it : trust){
            inDegrees[it[0]]--;
            inDegrees[it[1]]++;
        }

        for(int i = 0; i <= n; i++){
            if(inDegrees[i] == n-1) return i;
        }
        return -1;
    }
};
