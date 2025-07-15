# Time complexity: O(n + m)
# Space complexity: O(n)

def findJudge(n, trust):
    in_degree = [0] * (n + 1)
    out_degree = [0] * (n + 1)
    
    for a, b in trust:
        out_degree[a] += 1
        in_degree[b] += 1
    
    for i in range(1, n + 1):
        if in_degree[i] == n - 1 and out_degree[i] == 0:
            return i
    
    return -1
