public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1]; // index 1 to n

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            trustScore[a]--; // person a trusts someone -> cannot be judge
            trustScore[b]++; // person b is trusted by someone
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i; // Trusted by everyone else, trusts no one
            }
        }

        return -1; // No judge found
    }
}

/*
Time Complexity: O(t + n)
- t = number of trust relationships
- We process trust array and scan trustScore array

Space Complexity: O(n)
- Array to store trust score for each person
*/
