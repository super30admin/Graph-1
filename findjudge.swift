// Time Complexity : O(N^3)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    func findJudge(_ n: Int, _ trust: [[Int]]) -> Int {
        if (trust.count == 0 || trust == nil) && n > 1 {
            return -1
        } else if n == 1 {
            return 1
        }
        var graph = [Int:[Int]]()
        for value in trust {
            if let people = graph[value[0]] {
                var people = people
                people.append(value[1])
                graph[value[0]] = people
            } else {
                graph[value[0]] = [value[1]]
            }
    }
    var count = 0
        var propablejudge = 0
    for person in 1...n {
        if graph[person] == nil  {
            count += 1
            propablejudge = person
        }
    }
    if count >= 2 {
        return -1
    }
    return isJudge(graph,propablejudge) ? propablejudge : -1
    }
    private func isJudge(_ graph: [Int:[Int]], _ person: Int) -> Bool {
        for (_,people) in graph {
            if !people.contains(person) {
                return false
            }
        }
        return true
    }