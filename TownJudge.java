
//Time Complexity: O(n) where n is the size of the trust array.
//Space Complexity: O(n)
//Intuition: The algorithm uses two arrays to keep track of how many people each person trusts and how many people trust each person.
// The person who is trusted by everyone else and trusts no one is the town judge.

public class TownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            return N == 1 ? 1 : -1;
        }

        int[] t = new int[N];
        int[] trusted = new int[N];
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            t[a - 1]++;
            trusted[b - 1]++;
        }

        for (int i = 0; i < N; i++) {
            if (t[i] == 0 && trusted[i] == N - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
