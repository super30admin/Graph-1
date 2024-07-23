//time - O(V+E), space - O(V)
class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {

        if(n == 1) {
            return 1;
        }

        int[] indegrees = new int[n+1];

        for(int[] t : trust) {
            indegrees[t[0]]--;
            indegrees[t[1]]++;
        }

        for(int i=0; i<indegrees.length; i++) {
            if(indegrees[i] == n-1) {
                return i;
            }
        }

        return -1;
    }
}
