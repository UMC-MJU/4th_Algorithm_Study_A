n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]
rst = 1e9
def dfs(l,sin,sun):
    global rst
    if l == n:
        if sin ==1 and sun == 0:
            return
        rst = min(rst,abs(sin-sun))
        return
    dfs(l+1,sin*data[l][0],sun+data[l][1])
    dfs(l + 1, sin, sun)

dfs(0,1,0)
print(rst)