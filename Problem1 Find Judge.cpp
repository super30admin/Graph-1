// t-c: E; E = trust relationships
//s-c: E

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<set<int>> v(n + 1);
        vector<set<int>> v3(n + 1);
        map<int,int> mp;
        for(int i=0;i<trust.size();i++) {
            v[trust[i][1]].insert(trust[i][0]);
            v3[trust[i][0]].insert(trust[i][1]);
        }
        
        int ans = -1;
        for(int i=0;i<v.size();i++) {
            if(v[i].size() == n - 1) {
                ans = i;
                if(v3[ans].size() > 0) {
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }
};