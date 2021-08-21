class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust == null) {
            return 0;
        }
        
        if(N == 1) {
            return 1;
        }         
        
        if(trust.length < N-1) {
            return -1;    
        }
        
        int[] array = new int[N];
        
        for(int[] t : trust) {
            array[t[0]-1]--;
            array[t[1]-1]++;
        }
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] == N - 1) {
                return i+1;
            }
        }
        return -1;
    }
}

//Time : O(E+V)
//Space : O(N)