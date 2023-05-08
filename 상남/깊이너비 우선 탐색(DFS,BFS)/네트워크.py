def solution(n, computers):
    cnt = 0
    def dfs(v):
        visited[v] = True
        
        for j in range(n):
            # 방문하지 않은 곳 중에서 연결된 곳 방문
            if computers[v][j] == 1 and visited[j] == False:
                dfs(j)
                    
    visited = [False] * n
    
    for v in range(n): #노드 방문
        if visited[v] == False:
            dfs(v)
            cnt += 1
    return cnt
print(solution(3,[[1, 1, 0], [1, 1, 0], [0, 0, 1]]))