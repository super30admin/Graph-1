using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Graph
{
    class FindJudge
    {
        /*
         * T.C: O(V+E) where v is vertices (people) & e is edges
         * S.C: O(V)
         */
        public int FindJudge(int n, int[][] trust)
        {

            if (n == 0) return -1;


            int[] indegree = new int[n + 1];


            foreach (int[] t in trust)
            {
                indegree[t[0]]--;
                indegree[t[1]]++;
            }

            for (int i = 1; i <= n; i++)
            {
                if (indegree[i] == n - 1)
                {
                    return i;
                }
            }
            return -1;
        }
    }
}
