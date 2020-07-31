// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
 //use BFS, from staring position iterate all four directions and find wall to mark r,c to 2 and push into queue. return true when destination found otherwise false

class Solution {
    func hasPath(_ input: [[Int]], _ start: [Int], _ destination: [Int]) -> Bool {
        var maze = input;
        //edge case 
        if maze.count == 0 {
            return false
        }
        
        //logic
        //use BFS. find the wall and mark the r,c to 2 and push into queue
        var m = maze.count
        var n = maze[0].count
        var queue: [[Int]] = [[Int]]()
        queue.append(start)
        let directions = [[0,-1], [0,1],[-1,0],[1,0]]  //left, right, up, down
        while !queue.isEmpty {
            let current = queue.removeLast()
            let i = current[0]
            let j = current[1]
            if i == destination[0] && j == destination[1] {
                return true
            }
            for dir in directions {
                var r = current[0]
                var c = current[1]
                while r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1 {
                    r += dir[0]
                    c += dir[1]
                }
                r -= dir[0]
                c -= dir[1]
                if maze[r][c] != 2 {
                    maze[r][c] = 2
                    queue.append([r,c])
                }
            }
        }
        return false
    }
}