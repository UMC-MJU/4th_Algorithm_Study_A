from collections import deque
def bfs(j,k):
    q = deque()
    q.append((j,k))

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= n or nx < 0 or ny >= n or ny < 0: # 범위 벗어나지 않게 하기
                continue

            if visited[nx][ny] == False: # 방문안한 곳 방문처리
                visited[nx][ny] = True
                q.append((nx,ny))


n = int(input())
big = 0
# small = 100
data = []
dx = [0,0,-1,1]
dy = [1,-1,0,0]
for i in range(n):
    tmp_data = list(map(int, input().split()))
    big = max(max(tmp_data),big) # data값중에서 가장 큰값 구하기
    # small = min(min(tmp_data),small) # data값중에서 가장 작은 값을 구하면 안되나봅니다 -> 비가 안오는 경우도 생각해야하나봐요
    data.append(tmp_data)
rst = 0
for i in range(big+1):
    visited = [[False] * n for _ in range(n)] # 방문처리 변수
    cnt = 0
    for j in range(n):
        for k in range(n):
            if data[j][k] <= i: # 물에 잠긴 곳 표시
                visited[j][k] = True

    for j in range(n):
        for k in range(n):
            if visited[j][k] == False: # 물에 안잠긴 곳에서 bfs 시작
                bfs(j,k)
                cnt += 1 # 안전영역 구하기
    rst = max(rst,cnt) # 최대 안전 영역 구하기
print(rst)