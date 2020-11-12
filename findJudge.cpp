//time complexity:O(E)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using graph
//any issues faced? no

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        if(trust.size()<N-1)
            return -1;
        vector<int>indegree(N+1);
        vector<int>outdegree(N+1);
        for(vector<int>relation:trust)
        {
            outdegree[relation[0]]++;
            indegree[relation[1]]++;
        }
        for(int i=1; i<=N; i++)
        {
            if(indegree[i]==N-1 && outdegree[i]==0)
                return i;
        }
        return -1;
    }
};