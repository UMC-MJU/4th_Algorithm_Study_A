from collections import deque

# 가로 크기 N, 세로 크기 M
N, M = map(int, input().split())

# 병사 배치 정보
graph = [list(input()) for _ in range(M)]

# 상하좌우 좌표 정보
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 아군, 적군 위력
White = 0
Blue = 0


# 큐 구현
def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = True
    count = 0
    power = 0
    global White, Blue

    # 큐가 빌 때 까지
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 전쟁터 벗어나는 경우 제외
            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue

            # 방문하지 않았고, 같은 팀 병사라면
            if not visited[nx][ny] and graph[x][y] == graph[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True
        count += 1
    power = count * count

    if graph[x][y] == 'W':
        White += power
    else:
        Blue += power


# 방문 정보 2차원 배열
visited = [[False] * N for _ in range(M)]

for a in range(M):
    for b in range(N):
        if not visited[a][b]:
            bfs(a, b)

print(White, Blue)
