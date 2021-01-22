//Time - O(N)
//Space - O(N)
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        if(N==0) return -1;
        
        vector<int> indeg (N,0);
        
        for(auto t:trust){
            indeg[t[0]-1]--;
            indeg[t[1]-1]++;
        }
        
        for(int i=0;i<N;i++){
            if(indeg[i] == N-1){
                return i+1;
            }
        }
        
        return -1;
    }
};