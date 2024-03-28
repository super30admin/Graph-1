package week9.day4;
class Program2 {
    public int findJudge(int n, int[][] trust) {
            if(n==1)
                return 1;
            int[] dp = new int[n+1]; //bec idx starts from 0
            for(int i=0;i<trust.length;i++){
                int[] t = trust[i];
                dp[t[0]] = dp[t[0]] -1;
                dp[t[1]] = dp[t[1]]+1;
            }
            
            for(int i=0;i<dp.length;i++){
                if(dp[i]==n-1)  //final trust should be n-1
                    return i;
            }
            return -1;
        }
}
public class FindTownJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program2 p = new Program2();
		int[][] trust= {{1,3},{2,3}};
		int n=3;
		System.out.println(p.findJudge(n, trust));

	}

}
