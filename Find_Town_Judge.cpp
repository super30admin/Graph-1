//Time Complexity:O(e+v), where v=no.of people & e=no.of trust pairs.
//Space Complexity:O(v)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int>in(n + 1, 0);
        vector<int>out(n + 1, 0);
        for(auto& x:trust){
             in[x[1]]++;
            out[x[0]]++;
        }
        for(int i = 1; i <= n; i++){
            if(in[i] == n-1 && out[i] == 0)
                return i;
        }
        return -1;
    }
};