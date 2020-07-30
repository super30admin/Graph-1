//Time complexity : O(n)
//Space Complexiy : O(n) For saving In edges for each node
//Runs successfully on leetcode
//No problem

//Here while traversing in trust array we will keep an array of trusts for each node
//The node will n-1 trusts will be our answer

public class Graph_1_Problem_1_findJudge {

    public int findJudge(int N, int[][] trust) {


        int[] trustArr = new int[N];

        for(int[] arr : trust)
        {
            trustArr[arr[0]-1]--;
            trustArr[arr[1]-1]++;
        }

        for(int i = 0 ; i < trustArr.length ; i ++)
        {
            if(trustArr[i] == N-1)
            {
                return i+1;
            }
        }

        return -1;
    }
}
