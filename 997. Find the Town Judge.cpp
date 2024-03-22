/*
Time: O(n)
Space: O(n)

The town judge will have indegree = n-1 and outdegree = 0
(Special consideration: check if two people qualify for town judge!)
*/

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& t) {
        vector<int> trusts(n+1,0); //outdegree
        vector<int> trusted(n+1,0); //indegree

        for(auto &v: t){
          trusts[v[0]]++;
          trusted[v[1]]++;
        }

        int ans = -1;
        for(int i=1;i<=n;i++){
          if(trusts[i]==0 && trusted[i]==n-1){
            if(ans != -1)  return -1; //two people qualify for town judge!
            ans = i;
          }
        }

        return ans;
    }
};
