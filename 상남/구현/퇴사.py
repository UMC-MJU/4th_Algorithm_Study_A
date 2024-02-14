n = int(input())
t = []
p = []
for i in range(n):
    a,b = map(int, input().split())
    t.append(a)
    p.append(b)
print(t)
print(p)
ans = 0
def dfs(v,sum):
    global ans

    if v >=n:
        ans = max(ans,sum)
        return

    if v+t[v] <= n:
        dfs(v+t[v],sum+p[v])
    dfs(v+1,sum)


dfs(0,0)
