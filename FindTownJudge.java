//The idea here is to make a graph of the given trusts in trust array
//To achieve this, we create an indegrees array by adding 1 to the person who is trusted and subtracting 1 from the person who trusts
//If any indegrees array value equals n-1, then that's the town judge, else no town judge
//Time Complexity: O(V+E) where V and E are the vertices and edges of the graph
//Space Complexity: O(n) for indegrees array
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];
        for(int[] tr: trust){
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }

        for(int i = 1; i<indegrees.length; i++){
            if(indegrees[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}