*****//114.997. FIND TOWN JUDGES****
//Time complexity: 0(v+e);
//Space complexity :0(n);

  
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        //Declaring array
        int[] indegree=new int[n];
        for(int[] t: trust)
        {
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }
        
        //Iterate through array
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==n-1)
            {
                return i+1;
            }
        }
        
        return -1;
    }
}
