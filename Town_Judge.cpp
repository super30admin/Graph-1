//Time Complexity-O(n)-->'n' is number of trust pairs
//Space Complexity-O(N)-->'N' is number of people
//Did the code execute on Leetcode? yes

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        if(N==0)
        {
            return 0;
        }
        vector<int>m(N,0);
        for(int i=0;i<trust.size();i++)
        {
            m[trust[i][0]-1]--;
            m[trust[i][1]-1]++;
        }
        int res=-1;
        for(int i=0;i<m.size();i++)
        {
            if(m[i]==N-1)
            {
                res=i+1;
            }
        }
        return res;
    }
};