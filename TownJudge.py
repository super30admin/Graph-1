"""
Rasika Sasturkar
Time complexity: O(V+E), V-vertices of the graph, E-edges
Space complexity: O(V)
"""


def findJudge(n: int, trust) -> int:
    """
    Create an array of in-degrees with initially all zeros.
    Decrease the value for the person trusting other person and
    increase the value of person who is gaining trust.
    At the end, return the node with value equal to (n-1).
    """
    indegree = [0 for _ in range(n)]

    for each_trust in trust:
        indegree[each_trust[0] - 1] -= 1
        indegree[each_trust[1] - 1] += 1

    for i in range(len(indegree)):
        if indegree[i] == n - 1:
            return i + 1
    return -1


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(findJudge(n=2, trust=[[1, 2]]))  # returns 2
    print(findJudge(n=3, trust=[[1, 3], [2, 3]]))  # returns 3
    print(findJudge(n=3, trust=[[1, 3], [2, 3], [3, 1]]))  # returns -1


if __name__ == "__main__":
    main()
