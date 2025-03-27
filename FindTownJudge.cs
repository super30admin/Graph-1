//time complexity - O(m*n) - m = edges, n = vertices
//space cmplexity - O(1)
public class Solution
{
    public int FindJudge(int n, int[][] trust)
    {
        int[] indegrees = new int[n + 1];
        foreach (int[] arr in trust)
        {
            indegrees[arr[0]]--;
            indegrees[arr[1]]++;
        }
        int res = Int32.MinValue;
        int townJudge = 0;
        for (int i = 1; i <= n; i++)
        {
            if (indegrees[i] == n - 1)
            {
                return i;
            }

        }
        return -1;
    }
}