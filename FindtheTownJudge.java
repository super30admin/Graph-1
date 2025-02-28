// TC: O(V + E) where v is vertices and e is edge
// SC: O(E) is the total number of Edge

// Indegrees array maintains the count of incoming/outgoing by ++/-- respectively.
// Then the indegrees values are checked against the n-1
public class FindtheTownJudge {

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][] { { 1, 2 } })); // 2
        System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } })); // 3
        System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } })); // -1
    }

    public static int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1)
            return 1;
        int[] indegrees = new int[n];
        for (int i = 0; i < trust.length; i++) {
            indegrees[trust[i][0] - 1]--;
            indegrees[trust[i][1] - 1]++;
        }
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == n - 1)
                return i + 1;
        }
        return -1;
    }
}