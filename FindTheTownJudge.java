TC:O(n) 
SC:O(n) -hashset
succeffully run on leetcode

used hashset to store the peopl lable and checked the trutees and also if the trustee is a judge or no
class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<trust.length;i++){
            set.add(trust[i][0]);
        }
        if(set.size()==n) return -1;
        int judge=0;
        for(int i=0;i<n;i++){
              if(!set.contains(i+1)){
                  judge = i+1;
              }
        }

        HashSet<Integer>set1 = new HashSet<>();
        set1.add(judge);
        for(int i=0;i<trust.length;i++){
            if(trust[i][1] == judge) set1.add(trust[i][0]);
        }
        if(set1.size()==n) return judge;
        else return -1;
    }
}