// Time O(N)
// Space O(N)

public class FindTheTownJudge {
	  public int findJudge(int n, int[][] trust) {
	        
	        int[] arr = new int[n+1];
	        
	        for(int[] curr:trust){
	            arr[curr[1]]++;
	            arr[curr[0]]--;
	        }
	        for(int i=1;i<=n;i++){
	            if(arr[i]==n-1)
	                return i;
	        }
	        return -1;
	    }
}
