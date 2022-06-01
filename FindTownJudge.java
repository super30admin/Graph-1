class Solution {

    //Time Complexity: 0(V+E) where v is the vertices in the graph and e is the edges
    //Space Complexity: 0(v)
    //Did you face any problem while coding: No
    //Did it successfully run on leetcode: Yes

    //In brief explain your approach

    public int findJudge(int n, int[][] trust) {
        if(n == 0){
            return -1;
        }
        int [] indegree = new int [n + 1];  //creating an indegree array to store the inward and outward edges
        for(int [] t : trust){  //navigating through trust array
            indegree[t[0]]--;   //if a trusts b, then we deduct deduct 1 from a
            indegree[t[1]]++;   //and add 1 to b
        }
        for(int i = 1; i <= n; i++){    //navigating through indegrees array
            if(indegree[i] == n - 1){   //returning if there is a value which is 1 less than total no. of candidates
                return i;
            }
        }
        return -1;
    }
}