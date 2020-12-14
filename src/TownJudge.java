
public class TownJudge {
	public int findJudge(int N, int[][] trust) {
		int[] indegree = new int[N];

		for (int[] tr : trust) {
			indegree[tr[0] - 1]--;
			indegree[tr[1] - 1]++;
		}

		for (int i = 0; i < N; i++) {

			if (indegree[i] == N - 1) {
				return i + 1;
			}
		}

//		int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
//		System.out.println("length is " + dirs.length);
//		for (int i = 0; i < dirs.length; i++) {
//			int[] arr = dirs[i];
//
//			for (int j = 0; j < arr.length; j++) {
//				System.out.println(dirs[i][j]);
//			}
//		}

		return -1;

	}

	public static void main(String[] args) {
		TownJudge jud = new TownJudge();
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		jud.findJudge(3, trust);
	}
}
