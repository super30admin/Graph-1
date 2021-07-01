import java.util.Arrays;

//Time Complexity -O(N)
//Space Complexity - O(N)
public class FindJudge{
	public int findJudge(int N, int[][] trust) {
     	int array[] = new int[N + 1];

     	for(int t[] : trust){
     		array[t[0]]--;
     		array[t[1]]++;
     	}
     	for(int i =0; i < N; i++){
     		if(array[i] == N - 1){
     			return i;
     		}
     	}
     	System.out.println(Arrays.toString(array));
     	return -1;
    }

    public static void main(String args[]){
    	int trust[][] = {{1,3},{2,3},{3,1}};

    	int N = 3;

    	FindJudge find = new FindJudge();
    	System.out.println(find.findJudge(N,trust));

    }
	
}