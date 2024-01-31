n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
rst = [[0]*n for _ in range(n)]
big = 0
def dfs(v,sum):
    global big
    print(v,sum)
    if v + data[v][0] >= n: # n+1 회사 x
        print("v",v,data[v][0])
        big = max(big,sum)
        return

    if rst[v][v + data[v][0]] != 0: # 이미 dp있으면 x
        sum += rst[v][data[v][0]]
        big = max(big, sum)
        return
    else:
        rst[v][v + data[v][0]] = data[v][1]
        dfs(v + data[v][0], sum+data[v][1])

for i in range(n):
    dfs(i,0)
print(big)