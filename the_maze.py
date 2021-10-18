# // Time Complexity :mn * max(m,n)
# // Space Complexity :O(mn)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
def fn():
    arr=[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
    q=[]
    dirs=[[0,1],[1,0],[-1,0],[0,-1]]
    source=(0,4)
    destination=(4,4)
    q.append((0,4))
    while q:
        temp=q.pop(0)
        for i in dirs:
            x=temp[0]
            y=temp[1]
            while x>=0 and y>=0 and x<len(arr[0]) and y<len(arr) and arr[x][y] != 1:
                x=x+i[0]
                y=y+i[1]
            x=x-i[0]
            y=y-i[1]
            if arr[x][y]==0:
                if x==destination[0] and y==destination[1]:
                    return True
                
                arr[x][y]=2
                q.append((x,y))
    return False

print(fn())

        

    