from collections import deque
n,l,r = map(int, input().split())
data = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
cha = r - l

check = [[False]*(n+1) for i in range(n+1)]

def bfs():
    pass

q = deque()
q.append((0,0))

while q:
    x,y = q.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

