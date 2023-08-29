//time: O(V+E)
//Space: O(V)

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {

        vector<int> indegrees(n,0);
        for(vector<int> tr:trust){
            indegrees[tr[0]-1]--;
            indegrees[tr[1]-1]++;
        }

        for(int i=0;i<n;i++){
            if(indegrees[i]==n-1){
                return i+1;
            }
        }

        return -1;

        
    }
};