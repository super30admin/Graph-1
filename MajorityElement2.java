//TC:O(n) where n is the number of elements
//SC:O(n)
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int val = nums.length/3;
        List<Integer> l = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //Getting count of each element
        for(int i=0; i<nums.length; i++){
            int k = map.getOrDefault(nums[i], 0);
            map.put(nums[i], k+1);
        }
        //Check if the count is greater than n/3 than add in list
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > val){
                l.add(entry.getKey());
            }
        }
        return l;
    }
}