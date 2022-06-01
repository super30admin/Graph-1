//TC = O(V + E) 
//SC = O(N)

import java.util.*;

public class FindTheTownJudge{

    public static int findJudge(int n, int[][] trust)
    {
        if(n == 0) return -1;

        int[] inAndOut = new int[n+1];

        for(int[] t: trust)
        {
            inAndOut[t[0]]--;
            inAndOut[t[1]]++;
        }

        for(int i = 1;i<=n;i++)
        {
            if(inAndOut[i] == n - 1)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String args[])
    {
        int[][] trust = {{1,3},{2,3},{3,1}};
        int n = 3;

        System.out.println(findJudge(n, trust));
    }
}