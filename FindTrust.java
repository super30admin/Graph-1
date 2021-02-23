//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Maintain an indegree array and check which index has max and is N-1 
// that index is the judge
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N];
        for(int[] arr: trust)
        {
            indegree[arr[0] - 1] -= 1;
            indegree[arr[1] - 1] +=1;
        }
        for(int i =0; i < N; i++)
        {
            if(indegree[i] == N-1)
                return i+1;
        }
        return -1;
    }
}