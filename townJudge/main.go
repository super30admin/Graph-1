func findJudge(n int, trust [][]int) int {
    indegree := make([]int, n)
    for i := 0; i < len(trust); i++ {
        person := trust[i][0]
        trustedPerson := trust[i][1]
        indegree[person-1]--
        indegree[trustedPerson-1]++
    }
    for i := 0; i < len(indegree); i++ {
        if indegree[i] == n-1{return i+1}
    }
    return -1
}
