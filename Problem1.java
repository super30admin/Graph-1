//Time = O(T + N), where T is the number of trust relationships and N is the number of people in the town
//Space = O(n), as we are using n+1 array size

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1]; // Array to store the number of people trusted by each person
        boolean[] trustsSomeone = new boolean[n + 1]; // Array to store whether each person trusts someone

        // Loop through each trust relationship and update trustCount and trustsSomeone accordingly
        for (int i = 0; i < trust.length; i++) {
            int truster = trust[i][0];
            int trustee = trust[i][1];

            trustCount[trustee]++; // Increment the number of people trusted by the trustee
            trustsSomeone[truster] = true; // Mark the truster as someone who trusts someone else
        }

        int judge = -1; // Initialize the town judge to -1
        for (int i = 1; i <= n; i++) {
            // If a person trusts no one and is trusted by everyone else, they are the town judge
            if (trustCount[i] == n - 1 && !trustsSomeone[i]) {
                if (judge == -1) {
                    judge = i; // Set the town judge to the current person
                } else {
                    return -1; // There cannot be more than one town judge, so return -1
                }
            }
        }

        return judge; // Return the town judge
    }
}
