//Time Complexity:  O(V+E); where V is the no of edges in trust array and E is n.
//Space Complexity: O(E)
//Code run successfully on LeetCode.

public class Problem1 {

    public int findJudge(int n, int[][] trust) {
        
        if((trust == null|| trust.length == 0) && n!=1 )
            return -1;
        
        int[] res = new int[n+1];
        
        for(int i =0; i < trust.length; i++)
        {
            res[trust[i][0]]--;
            res[trust[i][1]]++;
        }
        
        for(int i =1; i < n +1; i++)
        {
            if(res[i] == n -1)
                return i;
        }
        
        return -1;
    }
}
