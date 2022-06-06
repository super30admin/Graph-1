//TC : O(V+E)
//SC : O(V)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0) return -1;
        //if(n==1) return 1;
        int[] in = new int[n];

        for(int[] i : trust)
        {
            int incoming = i[1];
            int outgoing = i[0];

            in[incoming-1]++;
            in[outgoing-1]--;
        }

        for(int i =0;i<in.length;i++)
        {
            //System.out.println(in[i]);
            if(in[i]==n-1)
                return i+1;
        }
        return -1;
    }
}