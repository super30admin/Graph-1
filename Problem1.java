// town judge 

//form an array equal to n , each cell will have number of elements pointing to that cell. 
//the cell whose value is n, is the town judge, also decrease the cell value of person who trusts

//tc - O(V+E) v = number of people. E - number of connections
//sc - O(n)

class Problem1{
    public static void main(String args[]){
        Problem1 p = new Problem1();
        int[][] trust = {{1,3},{2,3}};
        System.out.println(p.findJudge(3, trust));
    }
    public int findJudge(int N, int[][] trust) {
        if(trust == null || trust.length ==0){
            return 1;
        }
        if(N ==1){
            return 1;
        }
        int[] count = new int[N+1];
        for(int i = 0;i< trust.length;i++){
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }

        for(int i = 0;i<=N; i++){
            if(count[i] == N-1){
                return i;
            }

        }
        return -1;

    }

}