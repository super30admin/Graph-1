/*
TC = O(V+E)
SC = O(V)
where V+E is the size of the trust vector and V is the number of peoples.   
*/
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if(n==0)
            return -1;
        int i;
        vector<int> indegree(n,0);
        for(auto t : trust)
        {
            indegree[t[1]-1]++;
            indegree[t[0]-1]--;
        }
        for(i=0;i<n;i++)
            if(indegree[i]==n-1)
                return i+1;
        return -1;
    }
};
