public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n];

        for (int[] tr : trust) {
            indegrees[tr[0] - 1]--;
            indegrees[tr[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTownJudge findTownJudge = new FindTownJudge();

        // Example input
        int n = 4;
        int[][] trust = {
                { 1, 3 },
                { 1, 4 },
                { 2, 3 },
                { 2, 4 },
                { 4, 3 }
        };

        int judge = findTownJudge.findJudge(n, trust);
        System.out.println("The judge is: " + judge);
    }
}
