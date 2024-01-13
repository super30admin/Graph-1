//T.C O(E+n) where E is number of edges ie., size of trust array
//S.C O(n)
//Successful in LeetCode : yes

//Create inorder matrix by giving score +1 for gaining trust and -1 for giving trust. At the end, the one who has score equal to n-1 is the judge.
class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int m = trust.length;
        int[] inOrder = new int[n+1];
        int trustee, trusted;
        for(int[] t: trust){
            trustee = t[0];
            trusted = t[1];
            inOrder[trustee]--;
            inOrder[trusted]++;
        }
        for(int i=1;i<n+1;i++){
            if(inOrder[i] == n-1)
                return i;
        }
        return -1;
    }
}