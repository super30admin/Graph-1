//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int findJudge(int N, int[][] trust) {
        //taking HashMap to store who trusts and who is trusted
        int[] indegrees = new int[N];
        
        for(int[] t : trust){
            //[1,2] -> 1 trusts 2
            //decrement value for whoever trusts
            //increment value for whoever is trusted
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        for(int i=0; i<N;i++){
            //go over the map again to find if N-1 trusted value exists
            //since then that person is trusted by all
            if(indegrees[i]==N-1){
                //index+1 person
                return i+1;
            }
        }
        //if no value is equal to N-1; return -1
        return -1;
    }
}