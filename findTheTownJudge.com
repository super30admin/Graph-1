package DataStructure.Graphs;

// Time Complexity : Add : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        findJudge(n, trust);
    }

    public static int findJudge(int n, int[][] trust) {

        int[] inorder = new int[n];  // S.C - O(N)

        // Decrement the person value who trusts others
        //Increment the person value who is being trusted
        for(int[] t : trust){ // T.C - O(N)
            inorder[t[0]-1]--;   // 0 indexed
            inorder[t[1]-1]++;
        }

        for(int i=0; i<inorder.length; i++){  // T.C - O(N)
            if(inorder[i]+1 == n)
                return i+1;
        }

        return -1;
    }
}

