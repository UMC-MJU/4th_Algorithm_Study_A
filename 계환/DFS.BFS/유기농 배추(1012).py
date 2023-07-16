t = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 큐 구현
def bfs(x, y):
    queue = [(x, y)]
    matrix[x][y] = 0  # 방문처리

    # 큐가 빌 때 까지
    while queue:
        x, y = queue.pop(0)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 행렬 밖으로 나가는 경우 제외
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue

            if matrix[nx][ny] == 1:  # 방문하지 않은 경우
                queue.append((nx, ny))
                matrix[nx][ny] = 0


# 행렬 만들기
for i in range(t):
    m, n, k = map(int, input().split())

    matrix = [[0] * n for _ in range(m)]
    count = 0

    # 배추 심어진 땅은 1로
    for j in range(k):
        x, y = map(int, input().split())
        matrix[x][y] = 1

    # 행렬 돌면서 1인 땅은 bfs 하고 count +1
    for a in range(m):
        for b in range(n):
            if matrix[a][b] == 1:
                bfs(a, b)
                count += 1
    print(count)

