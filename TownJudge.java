/*time complexity O(N) space complexity O(N) due to indegrees array
approach: we maintain a indegree array and store the indegrees for all the members and if a person has indegree equal to n-1 he is judge */

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] in=new int[N];
        for(int[] t: trust){
            in[t[0]-1]--;
            in[t[1]-1]++;
        }
        for(int i=0;i<N;i++){
            if(in[i]==N-1){
                return i+1;
            }
        }
        return -1;
    }
}