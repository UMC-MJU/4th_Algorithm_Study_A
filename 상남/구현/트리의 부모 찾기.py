import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
# data = []
# check = {}
# tmp = [[] for _ in range(100001)]
# for i in range(n-1):
#     a,b = map(int, input().split())
#     if a not in check:
#         check.append(a)
#     if b not in check:
#         check.append(b)
#     if a > b:
#         data.append([b,a])
#     else:
#         data.append([a, b])
#
# for a,b in data:
#     if len(tmp[a]) == 0 and len(tmp[b]) != 0:
#         tmp[a].append(b)
#         continue
#     elif len(tmp[b]) == 0 and len(tmp[a]) != 0:
#         tmp[b].append(a)
#     else:
#         if a > b:
#             tmp[a].append(b)
#         else:
#             tmp[b].append(a)
#
# for i in range(2,n+1):
#     if i in check:
#         print(tmp[i][0])

# 리스트로 풀어보려하였지만 실패

data = [[] for _ in range(100001)]

for i in range(n-1):
    a,b = map(int,input().split())
    data[a].append(b)
    data[b].append(a)

q = deque()
q.append(1)
visited = [0] *(100001)
visited[1] = 1
while q:
    tmp = q.popleft()

    for i in data[tmp]:

        if visited[i] == 0:
            visited[i] = tmp
            q.append(i)

for i in range(2,n+1):
    print(visited[i])



