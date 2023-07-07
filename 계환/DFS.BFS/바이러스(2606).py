from collections import deque

# 컴퓨터의 개수
n = int(input())
# 네트워크 쌍 개수
line = int(input())

# 네트워크 연결 정보를 저장할 그래프 생성, 값 입력
# 컴퓨터 번호 1번 부터 시작하므로 (전체 개수 + 1)로 생성
graph = [[] for _ in range(n + 1)]
for _ in range(line):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


# 큐 구현
def bfs(i):
    queue = deque([i])
    answer = 0
    visited[i] = True

    while queue:
        node = queue.popleft()
        for next in graph[node]:
            if not visited[next]:
                visited[next] = True
                queue.append(next)
                answer += 1

    return answer


# 방문 정보 배열
visited = [False] * (n + 1)
print(bfs(1))
