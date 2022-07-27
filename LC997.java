// Time Complexity : O(V + E)
// Space Complexity : O(V)

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(n == 0)
            return -1;

        int[] inOrder =new int[n + 1];

        for(int people[]: trust){
            inOrder[people[0]]--;
            inOrder[people[1]]++;
        }

        for(int i = 0; i <= n; i++){
            if(i != 0 && inOrder[i] == n - 1)
                return i;
        }

        return -1;
    }
}