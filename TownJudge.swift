// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Find indegree and outdegree. The person who is having the indegree equal to N-1(except himself) then he is the judge.


class Solution {
    func findJudge(_ N: Int, _ trust: [[Int]]) -> Int {
        var indegree = [Int](repeating: 0, count: N)
        
        for person in trust {
            indegree[person[0]-1] -= 1
            indegree[person[1]-1] += 1
        }        
        for (index,person) in indegree.enumerated() {
            if person == N-1 {
                return index+1
            }
        }
        
        return -1
    }
}