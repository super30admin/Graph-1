/**
 * Time Complexity: O(n + t), where n is the number of people and t is the number of trust relationships.
 * - O(n) is for initializing the set with all people.
 * - O(t) is for processing the trust relationships to determine the potential judge and count how many people trust the candidate.

 * Space Complexity: O(n), where n is the number of people.
 * - The space complexity is determined by the HashSet used to keep track of potential judges and the integer variables used for processing.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        // Create a set of potential judges (initially all people from 1 to n)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++)
            set.add(i);

        // Iterate through the trust array to eliminate anyone who trusts someone else
        for (int[] t : trust) {
            // If a person trusts someone, remove them from the set of potential judges
            if (set.contains(t[0]))
                set.remove(t[0]);
        }

        // If there's no candidate left or more than one candidate, return -1
        if (set.size() != 1)
            return -1;

        // Get the remaining candidate (potential judge)
        int candidate = set.iterator().next();

        // Initialize a count to check how many people trust the candidate
        int count = 0;
        for (int[] i : trust) {
            // Increment the count if someone trusts the candidate
            if (i[1] == candidate)
                count++;
        }

        // If the candidate is trusted by exactly n-1 people, return the candidate
        // Otherwise, return -1 indicating no judge found
        return count == (n - 1) ? candidate : -1;
    }
}
