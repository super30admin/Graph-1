/*
    Algorithm:
        1. Make a new array of size say judges
        2. Traverse through the trust array, increment judges[b] by 1  and decrement judges[a] by 1.
        3. Traverse through judges array if there is some value which is equal to N-1 return that person
        
        Time Complexity: O(n)
        Space Complexity: O(n)
*/

class Solution {
    public int findJudge(int N, int[][] trust) {
        
       int[] judges = new int[N];
        
        for(int[] t: trust){
            judges[t[0]-1]--;
            judges[t[1]-1]++;
        }
        
        for(int i=0;i<judges.length;i++){
            if(judges[i]==N-1)
                return i+1;
        }
        
        return -1;
    }
}