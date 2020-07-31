Time Complexity: O(n). n is the number of elements in an array
Space Complexity: O(n)

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust==null) return -1;
        
        int[] count = new int[N];
        for(int[] trustArray:trust){
            count[trustArray[0]-1]--;
            count[trustArray[1]-1]++;
        }
        
        for(int i=0;i<count.length;i++){
            
            if(count[i]==N-1)
                return i+1;
        }
        return -1;
        
    }
}
