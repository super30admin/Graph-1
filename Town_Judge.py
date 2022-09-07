class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if len(trust)==0:
            if n==1:
                return 1
            else:
                return -1
            
        self.adjacency_list={}
        
        for u,v in trust:
            if u not in self.adjacency_list:
                self.adjacency_list[u]=[]
                
            self.adjacency_list[u].append(v)
            
        
        visited=[0 for _ in range(n+1)]
        
        for i in range(n+1):
            if i in self.adjacency_list:
                for u in self.adjacency_list[i]:
                    visited[u]+=1
                    
                
        if n-1 in visited:
            l=visited.index(n-1)
            if l in self.adjacency_list:
                return -1
            
            return l
        
        else:
            return -1
            
               
        
        
        
            
        
            
        