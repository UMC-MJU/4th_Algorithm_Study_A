from collections import deque

N = int(input())  # 지도의 크기 N x N

# 집 정보 2차원 배열, 숫자로 받으려면 map() 사용해야.
graph = [list(map(int, input())) for _ in range(N)]

# 상하좌우 이동 좌표
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

count = 0  # 단지 개수
answer = []  # 각 단지 내 집의 수 리스트


# 큐 구현
def bfs(x, y):
    global count
    house = 1  # 단지 내 집의 개수, 검사 대상도 집이 있는 것이기 때문에 1로 초기화
    queue = deque([(x, y)])
    graph[x][y] = 0  # 방문 했으면 0으로 바꿈

    while queue:  # 큐가 빌 때 까지
        a, b = queue.popleft()

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            # 맵을 나가는 경우 제외
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            if graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = 0  # 방문처리
                house += 1  # 집의 수 카운트 +1

    answer.append(house)
    count += 1  # 단지 개수 카운트 +1


for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            bfs(i, j)

answer.sort()  # 오름차순 정렬
print(count)
for i in range(count):
    print(answer[i])