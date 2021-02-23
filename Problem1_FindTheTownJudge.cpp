// Time Complexity :  O(V+E) where V is vertice and E is edge

// Space Complexity : O(N) where N is number of people

// Did this code successfully run on Leetcode :yes
// Did this code successfully run on Local Computer :yes
// Any problem you faced while coding this : no


// TC :O(V+E) where V is vertice and E is edge
// SC: O(N) where N is number of people


class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        
        if(N==0) return -1;
        vector<int> indegrees(N);//this is vector size of N because we are basically finding dependency for each member
        //this indegrees array show dependency the person who trusts is decremented by -1 and to who is trusted we increase by +1.
        // Next we check in the indegrees vector which is equal to n-1 as to be a judge all must trust you but you dont trust others
        
        for(auto t:trust){ //can also write "for(vector<int> t :trust)""
            indegrees[t[0]-1]--; //we do t[0] - 1 because in the question it is the person number but our indegrees start with index 0
            indegrees[t[1]-1]++; //in the question it is person number
        }
        
        for(int i=0;i<N;i++){ //to check who can be judge
            if(indegrees[i]==N-1) return i+1; 
        }
        
        return -1; // no judge found
        
    }
};