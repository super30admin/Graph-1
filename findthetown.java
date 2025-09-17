//Time Complexity: O(V + E), where V is the number of people and E is the number of trust relationships.
//SC: O(v) for the indegree array.

//Create indegrees[1..n]; for each (a,b) do indegrees[a]-- (a trusts someone) and indegrees[b]++ (b is trusted).
//The judge (if any) must have indegrees[i] == n-1 (trusted by all others, trusts nobody).
//Scan 1..n to find and return that i; if none matches, return -1.

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];

        for(int[] tr: trust){ //O(E)
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }

        for(int i=1; i<=n; i++){ //O(V)
            if(indegrees[i] == n-1) return i;
        }

        return -1;
    }
}
