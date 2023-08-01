n,m = map(int, input().split())
data = list(map(int, input(). split()))
data= list(set(data))
data.sort()
n = len(data)
tmp = [0] * (m)
def dfs(v,cnt):
    
    if v == m:
        for t in tmp:
            print(t, end = " ")
        print()
    else:
        for i in range(cnt,n):
            tmp[v] = data[i]
            dfs(v+1,i+1)
    
dfs(0,0)