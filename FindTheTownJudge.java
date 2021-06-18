public class FindTheTownJudge {

    //TC: O(N) - Iterating the array two times. O(2N)
    //SC: O(N) - where N is the number of people.
    public int findJudge(int n, int[][] trust) {
        // Constrain from the question - One should not trust anybody and all should
        // him/her
        // Intution - If the indegree should equal to number of people and out degree
        // should be 0
        // We need to find that guy

        // Calculate indegrees

        // for int[] : trust
        // Create indegree and out degree

        // Update the max of indegree and out degree

        int[] indegree = new int[n];

        for (int[] item : trust) {
            indegree[item[0] - 1]--;
            indegree[item[1] - 1]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = new int[][] {
            {1,2}
        };

        int result = new FindTheTownJudge().findJudge(2, trust);
        System.out.println("The result: "+result);
    }
}