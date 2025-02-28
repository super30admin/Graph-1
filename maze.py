# time: O(m*n(m+n))
#space: O (1)
def hasPath(maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
    
    return dfs(maze,start,destination)
def dfs(maze,st,dt):
    if st[0]== dt[0] and st[1]== dt[1]:
        return True
    
    dirs= [[0,1],[0,-1],[1,0],[-1,0]]
    
    for d in dirs:
        nr= st[0]+ d[0]
        nc= st[1]+ d[1]
        while nr >=0 and nc >=0 and nr < len(maze) and nc < len(maze) and maze[nr][nc]!=1:
            nr= nr+ d[0]
            nc= nc+ d[1]
        nr= nr - d[0]
        nc= nc - d[1]
        if maze[nr][nc]!=2:
            maze[nr][nc]=2
            if dfs(maze, [nr, nc], dt):
                return True
    return False

# Test Cases:
def test_hasPath():
    test_cases = [
        (
            [
                [0, 0, 1, 0, 0],
                [0, 0, 0, 0, 0],
                [0, 0, 0, 1, 0],
                [1, 1, 0, 1, 1],
                [0, 0, 0, 0, 0]
            ],
            [0, 4],
            [4, 4],
            True
        ),
        (
            [
                [1, 1, 0],
                [0, 0, 1],
                [1, 1, 0]
            ],
            [0, 2],
            [2, 0],
            False
        ),
        (
            [
                [0, 0, 0, 0, 0],
                [1, 1, 1, 0, 1],
                [0, 0, 0, 0, 0],
                [0, 1, 0, 1, 0],
                [0, 1, 0, 1, 0]
            ],
            [0, 0],
            [4, 4],
            False
        ),
        (
            [
                [0, 1],
                [0, 0]
            ],
            [0, 0],
            [1, 1],
            True
        )
    ]
    
    for i, (maze, start, dest, expected) in enumerate(test_cases, 1):
        assert hasPath(maze, start, dest) == expected, f"Test case {i} failed."
        print(f"Test case {i} passed.")

test_hasPath()
