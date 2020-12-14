import java.util.HashMap;

public class SolutionContest {
	int[] matchingStrings(String[] strings, String[] queries) {
		int[] arr = new int[queries.length];
		HashMap<String, Integer> map = new HashMap();
		for (String str : strings) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for (int i = 0; i < queries.length; i++) {
			if (map.containsKey(queries[i])) {
				arr[i] = map.get(queries[i]);
			}
		}

		return arr;
	}
	
	public static void main(String[] args) {
		SolutionContest c = new SolutionContest();
		String [] strings = new String[] {"ab","ab","abc"};
		String [] queries = new String[] {"ab","abc","bc"};
		c.matchingStrings(strings, queries);
		
	}
}
