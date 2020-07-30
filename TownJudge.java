Approach 1
Algorithm : Graph, Two Array Storage
Logic : We dont need adj matrix to calculate in degree or out degree you can calculate without adj matrix too.
Time Complexity : O(N)
Space Complexity : O(N)  

    public static int findJudge(int N, int[][] trust) {

        int[] in = new int[N+1];
        int[] out = new int[N+1];

        for( int[] i : trust){
            out[i[0]]++;
            in[i[1]]++;
        }

        for( int i =1 ; i <= N ; i++)
            if(in[i] == N-1 && out[i] == 0)
                return i;


        return -1;
    }
   
Approach 2
Algorithm : Graph, One Array
Logic :  We dont need adj matrix to calculate in degree or out degree you can calculate normally also.
Time Complexity : O(N)
Space Complexity : O(N)  

    public static int findJudge(int N, int[][] trust) {

        int[] degree = new int[N+1];

        for( int[] i : trust){
            degree[i[0]]--;
            degree[i[1]]++;
        }

        for( int i =1 ; i <= N ; i++)
            if(degree[i] == N-1)
                return i;

        return -1;
    }