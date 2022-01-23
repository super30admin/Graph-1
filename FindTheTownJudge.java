// Time Complexity: O(O+V) 
// Space Complexity: O(V)
// Traversal
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if( n == 0)
            return -1;
        
        int degree[] = new int[n];
        
        for(int [] edge : trust)
        {
            degree[edge[0] - 1]--;
            degree[edge[1] - 1]++;
        }
        
        for(int i = 0 ; i < degree.length ; i++)
        {
            if(degree[i] == n-1)
                return i+1;
        }
        
        return -1;
    }
}
