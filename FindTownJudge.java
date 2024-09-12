/*I used two integer arrays to represent who people trust and who were trusted.
After storing all values into the two arrays just go through those two arrays and find the person with 0 trust person and being trusted by N - 1 people.

Time Complexity: O(N).*/
public class FindTownJudge {
	
	public static int findJudge(int N, int[][] arr) {
        int[] trust = new int[N];
        int[] trusted = new int[N];
        for(int i = 0; i < arr.length; i++){
            int a = arr[i][0]; 
            int b = arr[i][1];
            trust[a - 1]++;
            trusted[b - 1]++;
        }
        for(int i = 0; i < N; i++){
            if(trust[i] == 0 && trusted[i] == N - 1)
                return i + 1;
        }
        return -1;
    }

	
	public static void main(String[] args) {
		int[][] input = {{1,2},{3,2}};
		int result = findJudge(3,input);
		System.out.println(result);
	}
}
