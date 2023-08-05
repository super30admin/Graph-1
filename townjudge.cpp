class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> v(n, 0); 
        vector<bool> t(n, false); 

        for(int i = 0; i < trust.size(); i++) {
            v[trust[i][1] - 1]++; 
            if(!t[trust[i][0] - 1]) t[trust[i][0] - 1] = true;  
        }

        for(int i = 0; i < v.size(); i++) {
            if(v[i] == n-1 && !t[i]) return i+1; 
        } 

        return -1;        
    }
};