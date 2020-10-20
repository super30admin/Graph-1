//Time Complexity-O(n)
//Space Complexity-O(n)
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[]incoming=new int[N+1];
        for(int[]t:trust)
        {
            incoming[t[0]]=-1;
            incoming[t[1]]=incoming[t[1]]+1;
        }
        for(int i=1;i<incoming.length;i++)
        {
            if(incoming[i]==N-1)
            {
                return i;
            }
        }
        return -1;
    }
}