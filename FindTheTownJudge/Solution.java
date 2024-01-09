// Time Complexity : O(m+n) -> O(m) (Because in most cases m will always be greater than n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findJudge(int n, int[][] trust) {

        if(trust.length < n-1) return -1;

        int[] arr = new int[n+1];

        for(int[] t: trust) {
            arr[t[0]]--;
            arr[t[1]]++;
        }

        for(int i=1; i<=n; i++) {
            if(arr[i] == n-1)
                return i;
        }

        return -1;
    }
}


/*
class Solution {
    public int findJudge(int n, int[][] trust) {

        //SC: O(n + n*n)
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //TC: O(n)
        for(int i=1; i<=n; i++) {
            set.add(i);
            map.put(i, new ArrayList<>());
        }

        //TC:O(m)
        for(int i=0; i<trust.length; i++) {
            int judge = trust[i][1];
            int person = trust[i][0];

            map.get(judge).add(person);

            if(set.contains(person))
                set.remove(person);
        }

        //TC:O(n)
        for(Integer i: set)
            if(map.containsKey(i) && map.get(i).size() == n-1)
                return i;

        return -1;
    }
}*/
