# 면접보는 승범이 https://www.acmicpc.net/problem/17835

import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정
# 도시의 수 N, 도로의 수 M, 면접장의 수 K
N, M, K = map(int, input().split())
graph = [[] for _ in range(M + 1)]

# 도시 번호 인덱스, 면접장까지의 최소 거리 값
# 가장 큰 값이 답
answer = [INF] * N

for _ in range(M):
    u, v, c = map(int, input().split())
    graph[u].append((v, c))

# 면접장이 배치된 도시의 번호 리스트
target_city = list(map(int, input().split()))

def dijkstra(start):
    distance = [INF] * (N + 1)
    queue = []
    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, now = heapq.heappop(queue)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, (cost, i[0],))

    for i in range(1, N+1):
        if i in target_city:
            # 최소 거리 테이블에서 면접장 도시 중 최소 거를을 answer 리스트에 넣어준다.
            answer[start-1] = min(answer[start-1], distance[i])

for i in range(1, N+1):
    dijkstra(i)

longest_city = max(answer)
print(answer.index(longest_city)+1)
print(longest_city)