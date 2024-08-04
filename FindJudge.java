//time complexit:O(m+n)
//space complexity:O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0)
        {
            return -1;
        }
        int[] arr= new int[n];
        for(int[] a:trust)
        {
            arr[a[0]-1]--;
            arr[a[1]-1]++;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==n-1)
            {
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] trust = {
            {1, 3},
            {2, 3},
            {3, 1}
        };
        int judge = solution.findJudge(n, trust);
        System.out.println("The judge is: " + judge); // Expected output: -1 (no judge as 3 trusts 1)
    }
}