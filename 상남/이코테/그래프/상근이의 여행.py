import sys
from collections import deque
input = sys.stdin.readline
t = int(input())

for i in range(t):
    n,m = map(int, input().split())
    data = [[] for _ in range(n+1)]
    visited = [False] *(n+1)

    for i in range(m):
        a,b = map(int, input().split())
        data[a].append(b)
        data[b].append(a)

    q = deque()
    q.append(1)
    visited[1] = True
    cnt = 0
    while q:
        tmp = q.popleft()

        for i in data[tmp]:
            if visited[i] == False:
                visited[i] = True
                cnt += 1
                q.append(i)

    print(cnt)
