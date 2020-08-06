
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did it run on leetcode : yes


class Solution {
    public int findJudge(int N, int[][] trust) {
        
        
        if(trust.length < N-1)
            return -1;
        
        int[] countArray = new int[N+1];
        for(int[] t : trust){
           countArray[t[0]]--;
           countArray[t[1]]++;
        }
        
        for(int i = 1 ; i <  countArray.length; i++){
            if(countArray[i] == N-1)
                return i;
        }
        
        return -1;
    }
}
