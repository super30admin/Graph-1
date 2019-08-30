//
// Created by shazm on 8/30/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> vec(N,0);
        for(auto x : trust){
            vec[x[0]-1]--; vec[x[1]-1]++;
        }

        for(int x = 1; x<N+1; x++){
            if(vec[x-1]==N-1){return x;}
        }
        return -1;
    }
};