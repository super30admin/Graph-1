//tc is O(n)
//sc is O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {

        if (n == 0)
            return -1;

        int[] array = new int[n];

        for (int[] value : trust) {
            array[value[0] - 1]--;
            array[value[1] - 1]++;

        }

        for (int i = 0; i < n; i++) {
            if (array[i] == n - 1) {
                return i + 1;
            }
        }

        return -1;

    }
}