from collections import deque
import sys

input = sys.stdin.readline
n,m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]

dx = [0,0,-1,1] # 하좌우
dy = [-1,1,0,0]

# 딱 오른쪽 밑에 도착하면 cnt+1
# visited는 어차피 큰 값이면 이동을 못하기 때문에 필요없다고 생각했다.
q = deque()
q.append((0,0,data[0][0]))
cnt = 0

while q:
    x,y,tmp = q.popleft()
    if x == (n-1) and y == (m-1):
        cnt += 1
        continue
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= n or nx < 0 or ny >= m or ny < 0:
            continue

        if data[nx][ny] < tmp:
            q.append((nx,ny,data[nx][ny]))

print(cnt)
# 이문제는 deque를 사용하면 안된다고 합니다. 왜인지모르겠어요 heappq를 사용하여 maxheap으로 풀어야한ㄴ다는데 ㅠㅠ 시간초과나서 못풀었어요 