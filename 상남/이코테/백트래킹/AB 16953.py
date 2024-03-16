a,b = map(int,input().split())
cnt = 0
def dfs(l,n):
    global cnt
    if n > b:
        return
    if n == b:
        print(l+1)
        exit()
    dfs(l+1,n*2)
    dfs(l + 1, int(str(n)+str(1)))
n = dfs(0,a)
if n == None:
    print(-1)
# bfs풀이가 더 좋을 듯