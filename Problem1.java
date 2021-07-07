// Time Complexity - O(m) where m is the number of edges or number of nows in trusts matrix
// Space Complexity - O(N) where N is the number of persons
// This Solution worked on LeetCode

In this finding the judge problem. The judge does not trust anyone and everyone else trusts the judge. So if we decrement the value from the person who trusts and increase the value of the person who is trusted we will end up with trust value for every person. The person with N-1 value that is everyone else trusts this person, we have found the judge.

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] visited = new int[N];
        for(int[] edge: trust){
            visited[edge[0]-1]--; //-1 because the person count starts from 1 but the index in visisted starts from 0
            visited[edge[1]-1]++;
        }
        for(int i=0; i< N;i++){
            if(visited[i] == N-1)   return i+1;
        }
        return -1; // If no judge is found
    }
}
