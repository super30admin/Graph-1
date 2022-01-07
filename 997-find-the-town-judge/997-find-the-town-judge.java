

class Solution {
    public int findJudge(int n, int[][] trust) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         HashSet<Integer> set = new HashSet<>();
//         if(n == 1){
//             return 1;
//         }
//         for(int i = 0; i < trust.length; i++){
//                 if(!map.containsKey(trust[i][1])){
//                     System.out.println(trust[i][1]);
//                     map.put(trust[i][1], 1);
//                 }
//                 else{
//                    map.put(trust[i][1], map.get(trust[i][1])+1); 
//                 }
                
//             }
        
//         for(int i = 0; i < trust.length; i++){
//             if(!set.contains(trust[i][0])){
//                 set.add(trust[i][0]);
//             }
//         }
//         int answer = -1;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() == n - 1) {
//                 answer = entry.getKey();
//             }
//         }
//         if(!set.contains(answer)){
//             return answer;
//         }
//         return -1;
        int[] result = new int[n+1];
        for(int i = 0; i < trust.length; i++){
            int add = trust[i][1];
            int sub = trust[i][0];
            result[add] +=1;
            result[sub] -=1;
        }
        for(int i = 1; i <=n; i++){
            if(result[i] == n-1){
                return i;
            }
        }
        return -1;
        
    }
}