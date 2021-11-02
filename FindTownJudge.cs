using System;
using System.Collections.Generic;
using System.Text;

namespace Graph
{
    class FindTownJudgeLC
    {
        //TC:O(V+E)
        //SC:O(n)
        public int FindJudge(int n, int[][] trust)
        {
            if (n == 0)
            {
                return -1;
            }
            int[] indegrees = new int[n];
            foreach (int[] t in trust)
            {
                indegrees[t[0] - 1]--;
                indegrees[t[1] - 1]++;
            }
            for (int i = 0; i < n; i++)
            {
                if (indegrees[i] == n - 1)
                {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
