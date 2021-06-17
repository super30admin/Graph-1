/*
Intuition: We can consider this as a directed graph problem as we have edges provided.

We create an indegrees array which represents the number of people trust a particular person.

Time Complexity: O(V+E), V= People/Vertices. E = Edges
Space Complexity: O(N), Number of People
*/
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trusts) {
        int indegres[n+1];
        for ( int i =1; i <= n; i++ ){
            indegres[i] = 0;
        }
        for ( auto trust: trusts){
            indegres[trust[0]] -=1;
            indegres[trust[1]] +=1;
        }
        for ( int i =1; i <= n; i++ ){
            if ( indegres[i] == n-1)
                return i;
        }
        return -1;
    }
};