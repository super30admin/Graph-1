//Time Complexity : O(V+E); where V=Number of nodes/Total number of people ; E= Number of edges/length of Trust array
//Space Complexity : O(V)
public class FindTownJudge {	
	/**Approach: Graph + Create indegree array**/
	public int findJudge(int n, int[][] trust) {
        int[] indegree= new int[n];
        for(int[] t: trust){
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }
        
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == n-1) return i+1;
        }
        return -1;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		FindTownJudge ob= new FindTownJudge();
		int n= 3;
		int[][] trust= {{1,3}, {2,3}};
		
		System.out.print("The town judge is : "+ob.findJudge(n, trust));			
	}
}
