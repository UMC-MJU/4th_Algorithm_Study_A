# 연구소 https://www.acmicpc.net/problem/14502

from collections import deque
import copy
import sys
input = sys.stdin.readline
# 연구소의 크기 N x M ; N = 세로, M = 가로
N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

# 상,하,좌,우 방향 정보  좌, 우, 상, 하
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 벽 3개를 세울 수 있는 모든 경우의 수 체크 후 바이러스 퍼뜨리고 안전영역 크기 재기

def bfs():
    queue = deque()
    # 기존의 graph값을 변경하지 않기 위해 deep copy.
    # 여기서 graph는 경우의 수에 따라 벽 3개가 추가된 graph이다.
    test_graph = copy.deepcopy(graph)

    for i in range(N):
        for j in range(M):
            if test_graph[i][j] == 2:  # 바이러스를 큐에 넣는다
                queue.append((i,j))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (0 <= nx < N) and (0 <= ny < M):
                # 빈칸에 바이러스 퍼뜨리기
                if test_graph[nx][ny] == 0:
                    test_graph[nx][ny] = 2
                    queue.append((nx,ny))

    # 바이러스가 퍼진 후 안전영역 크기 재기
    safezone_count = 0
    for row in test_graph:
        safezone_count += row.count(0)

    global answer
    answer = max(answer, safezone_count)  # 지속적으로 비교해서 answer값을 큰 값으로 업데이트

# 벽 3개를 만들 수 있는 모든 경우의 수를 체크하는 메서드
# 벽이 3개가 되면 bfs() 메서드를 호출하여 바이러스를 퍼뜨리고 안전영역을 체크하는 로직
def make_wall(count):

    if count == 3:
        bfs()
        return

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                make_wall(count+1)  # 재귀함수를 이용해서 벽 3개를 만들 수 있는 모든 경우의 수를 체크
                graph[i][j] = 0  # 새로운 조합을 만들기 위해 벽을 허물어준다. (백트래킹)

answer = 0
make_wall(0)
print(answer)