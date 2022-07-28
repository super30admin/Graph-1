//Time Complexity- O(E) //number of edges
//Space Complexity- O(n) //number of people

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        
        vector<int> trusts(N+1,0);
        vector<int> trustedby(N+1,0);
        
        for(int i=0;i<trust.size();i++){
            trusts[trust[i][0]]++;
            trustedby[trust[i][1]]++;
        }
        
        int answer=-1;
        for(int i=1;i<=N;i++){
            if(trusts[i]==0 && trustedby[i]==N-1){
                answer=i;
                break;
            }
        }
        return answer;
    }
};