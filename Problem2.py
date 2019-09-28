from collections import deque

class Solution:
	def PathExistence1(self, maze, start, destination):
		rows = len(maze)
		if rows == 0:
			return False
		cols = len(maze[0])
		visited = [[False for _ in range(cols)] for _ in range(cols)]
		queue = deque()
		queue.append(start)
		dirs = [[0,1],[1,0],[-1,0],[0,-1]]
		while len(queue) > 0:
			poppedval = queue.popleft()
			r = poppedval[0]
			c = poppedval[1]
			if visited[r][c]:
				continue
			if r == destination[0] and c == destination[1]:
				return True
			visited[r][c] = True
			for i in dirs:
				r = poppedval[0]
				c = poppedval[1]
				while r >= 0 and c >= 0 and r < rows and c < cols and maze[r][c] == 0:
					r += i[0]
					c += i[1]
				r -= i[0]
				c -= i[1]
				queue.append([r, c])
		return False

	def PathExistence2(self, maze, start, destination):
		rows = len(maze)
		if rows == 0:
			return False
		cols = len(maze[0])
		visited = [[False for _ in range(cols)] for _ in range(rows)]
		return self.helper(maze, visited, start, destination)

	def helper(self, maze, visited, start, destination):
		r = start[0]
		c = start[1]
		# base case
		if r == destination[0] and c == destination[1]:
			return True
		if r < 0 or c < 0 or r >= len(maze) or r >= len(maze[0]) or visited[r][c] == True:
			return False
		visited[r][c] = True
		dirs = [[0,1],[1,0],[-1,0],[0,-1]]
		for i in dirs:
			r = start[0]
			c = start[1]
			while r >= 0 and c >= 0 and r < len(maze) and c < len(maze[0]):
				r += i[0]
				c += i[1]
			r -= i[0]
			c -= i[1]
			if self.helper(maze, visited, [r, c], destination):
				return True
		return False


if __name__ == '__main__':
	pe = Solution()
	print(pe.PathExistence1([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4], [3,2]))
	print(pe.PathExistence2([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4], [3,2]))