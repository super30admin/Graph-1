# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I am trying C++ for the first time with this program. I create 2 maps with in degrees and out degrees and when an element has in-degree of N-1 I check if its
# out-degree is 0. If yes, I return that number, else continue search

#include <iterator>
#include <map>

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        map<int, int> in_degrees;
        map<int, int> out_degrees;
        if (trust.size() == 0 && N == 1) return 1;
        for(int i=0; i<trust.size(); i++) {
            vector<int> trustVector = trust[i];
            out_degrees[trustVector[0]] += 1;
            in_degrees[trustVector[1]] += 1;
        }
        map<int, int>::iterator  itr;
        for(itr = in_degrees.begin(); itr!=in_degrees.end(); itr++) {
            if(itr->second == N - 1 && out_degrees[itr->first]==0) {
                return itr->first;
            }
        }
        return -1;
    }
};
