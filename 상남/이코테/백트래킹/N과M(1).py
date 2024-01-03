n,m = map(int, input().split())

visited = [0 for i in range(n+1)]
rst = [0 for i in range(n+1)]
def dfs(L):
    if L == m:
        for i in range(m):
            print(rst[i], end = " ")
        print()
    else:
        for i in range(1,n+1):
            if visited[i] == 0:
                visited[i] = 1
                rst[L] = i
                dfs(L+1)
                visited[i] = 0

dfs(0)