//tc : O(n)
//sc : O(n)
//ran successfully 
//no problems

//check every element by adding it to the hashmap

class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) {
            return 1;
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int[] num : trust) {
            map1.put(num[0], map1.getOrDefault(num[0], 0) + 1);
            map2.put(num[1], map2.getOrDefault(num[1], 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (map2.containsKey(i) && map2.get(i) >= (n - 1) && map1.getOrDefault(i, 0) == 0) {
                return i;
            }
        }
        return -1;
    }
}