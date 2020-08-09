//Time complexity=O(N)
//Space complexity=O(N)
//Initially we are creating an array of length equal to the number of people. And then we are traversing the entire array of trust to check the dependency of each judge on each other. If there is an out-degree then we are decrementing the count and if there is in-degree then we are incrementing, in the array we created. The index at which the value= N-1 is our answer.    
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        
        int[] trustArr = new int[N];
        
        for(int[] arr : trust)
        {
            trustArr[arr[0]-1]--;
            trustArr[arr[1]-1]++;
        }
        
        for(int i = 0 ; i < trustArr.length ; i ++)
        {
            if(trustArr[i] == N-1)
            {
                return i+1;
            }
        }
        
        return -1;
    }
}