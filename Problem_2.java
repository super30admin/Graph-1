// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0 && N-1==0) return N;
        HashMap<Integer,List<Integer>> hash=new HashMap<>();
        for(int[] arr:trust){
            if(hash.containsKey(arr[0])){
                hash.get(arr[0]).add(arr[1]);
            }else{
                List<Integer> li=new ArrayList<>();
                li.add(arr[1]);
                hash.put(arr[0],li);
            }
        }
        if(hash.size()==N) return -1;
        HashMap<Integer,Integer> store=new HashMap<>();
        for(List<Integer> li:hash.values()){
            for(int k:li){
                if(store.containsKey(k)){
                    store.put(k,store.get(k)+1);
                }else{
                    store.put(k,1);
                }
            }
        }
        //System.out.println(hash);
        for(int i:store.keySet()){
            if(store.get(i)==(N-1)){
                return i;
            }
        }
        return -1;
    }
}

