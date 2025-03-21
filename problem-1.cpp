// https://leetcode.com/problems/find-the-town-judge/description/
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        int findJudge(int n, vector<vector<int>>& trust) {
            vector<int> ans(n+1,0);
            for(auto i:trust){
                ans[i[0]]--;
                ans[i[1]]++;
            }
            for(int i=1; i<=n; i++){
                if(ans[i] == n-1){
                    return i;
                }
            }
            return -1;
        }
    };