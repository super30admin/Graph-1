//time complexity - o(V+E)
//space complexity- O(V)
public class FindTownJudge {
    static int findJudge(int n, int[][] trust) {
        int[] people = new int[n];
        int m = trust.length;

        // counting trust on and from people
        for(int i = 0; i < m; i++) {
            people[trust[i][0] - 1] -= 1;
            people[trust[i][1] - 1] += 1;
        }


        //checking if more than one or even one of judge exists
        for(int i = 0 ; i < n; i++) {
            if(people[i] == n-1) return i+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {{1,2},{1,3},{2,1},{2,3},{1,4},{4,3},{4,1}};
        int j = findJudge(n, trust);
        if(j == -1) {
            System.out.println("No town judge exist!!!");
        } else {
            System.out.println("The town judge is: " + j);
        }
    }
}
