// TC => O(N) total number of elements in trust array
// SC => O(n) total number of people in the town

public class Solution
{
    public int FindJudge(int n, int[][] trust)
    {
        if (trust == null || n == 0)
        {
            return 0;
        }
        int[] judge = new int[n];
        for (int i = 0; i < trust.Length; i++)
        {
            judge[trust[i][0] - 1]--;
            judge[trust[i][1] - 1]++;
        }
        for (int i = 0; i < n; i++)
        {
            if (judge[i] == n - 1)
            {
                return i + 1;
            }
        }
        return -1;
    }
}