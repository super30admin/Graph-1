func hasPath(maze [][]int, start []int, destination []int) bool {
    m := len(maze)
    n := len(maze[0])
    
    sr := start[0]
    sc := start[1]
    dr := destination[0]
    dc := destination[1]

    dirs := [][]int{{1,0},{-1,0},{0,1},{0,-1}}
    
    maze[sr][sc] = 2
    q := [][]int{{sr,sc}}
    
    for len(q) != 0 {
        dq := q[0]
        q = q[1:]
        if dq[0] == dr && dq[1] == dc {
            return true
        }
        
        for _, dir := range dirs {
            r := dq[0] + dir[0]
            c := dq[1] + dir[1]
            for r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1 {
                r += dir[0]
                c += dir[1]
            }
            r -= dir[0]
            c -= dir[1]
            if r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 2 {
                maze[r][c] = 2
                q = append(q, []int{r,c})
            }
        }
    }
    
    return false
}
