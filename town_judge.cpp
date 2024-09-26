//Time Complexity - O(N)
//Space Complexity - O(N)
//Ran successfully on leetcode 
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int>indegree(N+1,0);
        /*cout<<indegree[0];
        for(int i=0;i<N+1;i++)
            indegree[i]=0;
        cout<<indegree[N+1];*/
        for(int i=0;i<trust.size();i++)
        {
            indegree[trust[i][0]]--;
            indegree[trust[i][1]]++;
        }
        for(int i=1;i<N+1;i++)
        {
            if(indegree[i]==N-1)
                return i;
        }
        return -1;
    }
};