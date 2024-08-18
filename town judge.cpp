//can also be done using 2 pass and hashset
//time: O(E)
//space: O(V)
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) { 
        int tSize = trust.size();
        //n is V, tSize is E
        vector<int> vec(n, 0);
        for(int i = 0; i < tSize; i++) {
            vec[trust[i][0]-1]--;
            vec[trust[i][1]-1]++;
        }
        for(int i = 0; i < n; i++) {
            if(vec[i] == n-1) return i+1;
        }
        return -1;
    }
};