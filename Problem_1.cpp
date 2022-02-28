/**
 * @Time Complexity:
 * O(E)  where E is the number of edges in the 
 * trust array
 * 
 */


/**
 * @Space Complexity:
 * O(N) where N is the number of people
 * 
 */


/**
 * @Time complexity:
 * We have to calculate the indegrees first.
 * Then if one value is trusting the other
 * value, then the indegree of the trusting value
 * is reduced by one and the indegree
 * of the trusted value is increased by one.
 * 
 * Then we iterate the indegree array. The index whose indegree
 * is 1 less than the size of the given array is our judge.
 * Because he is trusted by everyone else, so his indegree
 * will be total number of people -1.
 * 
 */





//The code ran perfectly

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegrees(n);
        for(auto tr : trust){
            indegrees[tr[0] -1]--;
            indegrees[tr[1] -1]++;
        }
            
            for(int i =0; i<indegrees.size(); i++){
                if(indegrees[i] == n-1) return i+1;
            }
            return -1;
    }
};