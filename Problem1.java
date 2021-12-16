// 2N approach
// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         HashMap<Integer, Integer> incoming = new HashMap<>();
//         HashMap<Integer, Integer> outgoing = new HashMap<>();

//         for(int i[]:trust){
//             helper(incoming, i[1]-1);
//             helper(outgoing, i[0]-1);
//         }
//         int res = -1;
//         for(int i=0;i<n;i++)
//             if(incoming.getOrDefault(i,0)==n-1 && outgoing.getOrDefault(i,0)==0)
//                 if(res!=-1)
//                    return -1;
//                 else
//                     res = i;

//         return res!=-1?res+1:-1;

//     }
//     public void helper(HashMap<Integer, Integer>  hs, int i){
//         hs.put(i, hs.getOrDefault(i,0)+1);
//     }
// }

class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[] = new int[n];
        for(int i[]:trust){
            arr[i[1]-1]++;
            arr[i[0]-1]--;
        }
        for(int i=0;i<n;i++)
            if(arr[i]==n-1)
                return i+1;
        return -1;
    }
}