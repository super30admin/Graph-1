# Graph-1

## Problem113 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled atrusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:

    Input: N = 2, trust = [[1,2]]

    Output: 2

Example 2:

    Input: N = 3, trust = [[1,3],[2,3]]

    Output: 3

Example 3:

    Input: N = 3, trust = [[1,3],[2,3],[3,1]]

    Output: -1

Example 4:

    Input: N = 3, trust = [[1,2],[2,3]]

    Output: -1

Example 5:

    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]

    Output: 3

## Problem114 The Maze (https://leetcode.com/problems/the-maze/)

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.


The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

 

Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0

0 0 0 0 0

0 0 0 1 0

1 1 0 1 1

0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)

Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.

 

Note:

There is only one ball and one destination in the maze.

Both the ball and the destination exist on an empty space, and they will not be at the same position initially.

The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.

The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
