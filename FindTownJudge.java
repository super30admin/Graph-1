// Time complexity: O(N) N-> number of people
// space: O(1)
class Solution {
    public int findJudge(int N, int[][] trust) {

        if(trust == null) return -1;

        int[] indegrees = new int[N];

        for(int[] t : trust){
            indegrees[t[0] - 1]--; // the person who trusts someone else
            indegrees[t[1] - 1]++; // the person who is trusted
        }

        // finding the town judge
        for(int i = 0 ; i < indegrees.length ; i++){
            if(indegrees[i] == N - 1){
                return i+1;
            }
        }
        return -1;
    }
}
