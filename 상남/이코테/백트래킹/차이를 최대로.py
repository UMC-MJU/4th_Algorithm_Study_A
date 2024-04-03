# from itertools import permutations
# n = int(input())
# data = list(map(int, input().split()))
# rst = 0
# data = list(permutations(data,n))
# for i in data:
#     sum = 0
#     for j in range(1,n):
#        sum += abs(i[j]-i[j-1])
#     rst = max(sum,rst)
# print(rst)

n = int(input())
data = list(map(int, input().split()))
rst = 0
ch = [0] *(n+1)
visited = [False] *(n)
rst = 0
def dfs(v):
    global rst
    if v == n:
        # print(ch)
        sum = 0
        for i in range(1,n):
            sum += abs(ch[i]-ch[i-1])
        rst = max(sum,rst)

    else:
        for i in range(n):
            if visited[i]:
                continue
            visited[i] = True
            ch[v] = data[i]
            dfs(v+1)
            visited[i] = False

dfs(0)
print(rst)
