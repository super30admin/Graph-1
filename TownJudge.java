public class TownJudge {
    //Time complexity: O(N)
    //Space Complexity: O(N)
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];

        for(int i =0; i< trust.length; i++){
            degree[trust[i][1]]++;
            degree[trust[i][0]]--;
        }

        for(int i = 1 ;i <=n; i++){
            if(degree[i] == n-1) return i;
        }

        return -1;

    }
}
