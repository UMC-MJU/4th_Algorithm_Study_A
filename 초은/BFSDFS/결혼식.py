# https://www.acmicpc.net/problem/5567
from collections import deque

n = int(input())
m = int(input())

arr = [[0 for i in range(n)] for i in range(n)]
for i in range(m):
    x, y = map(int, input().split())

    arr[x - 1][y - 1] = 1
    arr[y - 1][x - 1] = 1

visited = [0 for i in range(len(arr))]

def bfs(start):
    dq = deque()
    dq.append(start)
    visited[start] = 1
    while dq:
        top = dq.popleft()
        for i in range(len(arr)):
            if arr[top][i] == 1 and visited[i] == 0:
                visited[i] = visited[top] + 1
                dq.append(i)

bfs(0)
answer = 0

for i in visited:
    if 1 < i < 4:
        answer += 1

print(answer)
