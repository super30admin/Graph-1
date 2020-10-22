// Time Complexity : O(x+N) where x represnts the total number of trusts(first for loop) and N for finding the judge(second for loop)
// Space Complexity : o(N) where n is the array length of n people
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/*
Here since we know that the judge trusts no one and evryone trusts judge we can create an array of size(n+1) where '1' will be represented by indx 1
and o represents no person

We do ++ x times for a particular person if indegree is x (everyone trusts )
We do -- y times for a particular person if outdgeree is y(doesnt trust anybody)


for Int i=1 to n we see whose count = n-1 and return that person
if not found then we simply return -1
*/

class Solution {
    public int findJudge(int N, int[][] trust) {

        int[] isTrusted = new int[N + 1];

        for (int[] t : trust) {
            isTrusted[t[0]]--;
            isTrusted[t[1]]++;
        }

        for (int i = 1; i < isTrusted.length; i++) {
            if (isTrusted[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}