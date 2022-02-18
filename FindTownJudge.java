//TC: O(Edges) We will need to loop through the all edges in trust
//SC: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n]; //you can take n+1 and changes accordingly below
        for(int[] tr : trust){
            indegrees[tr[0] - 1]--; //persons id is 1 to n but our indegree is 0 - n so -1
            indegrees[tr[1] - 1]++; //increase count of person if he is being trusted

        }
        for(int i = 0; i < indegrees.length; i++ ){
                if(indegrees[i] == n-1) return i+1;
            }
        return -1;
    }
}