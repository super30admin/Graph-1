// Solution - HashMap Approach
// TC - O(n) - iterate over trust array once.
// SC - O(n) - HashMap space. Worst case all people trust the judge. 
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] t : trust) {
            map.put(t[1], map.getOrDefault(t[1], 0) + 1); // increment trust count for the person who is being trusted.
            map.put(t[0], map.getOrDefault(t[0], 0) - 1); // decrement trust count for the person who is trusting
                                                          // someone else.
        }
        for (int i = 1; i <= n; i++) { // iterate over all people and check if there is a person who is trusted by n-1
                                       // people and does not trust anyone else.
            if (map.containsKey(i) && map.get(i) == n - 1)
                return i;
        }
        return -1;

    }
}