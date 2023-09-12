# 특정 거리의 도시 찾기 ( https://www.acmicpc.net/problem/18352 )

import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 나타냄

# N = 도시의 개수 / M = 도로의 개수 / K = 거리 정보 / X = 출발 도시 번호
N, M, K, X = map(int, input().split())

# 각 도시에 연결되어 있는 도시에 대한 정보를 담을 2차원 배열
graph = [[] for _ in range(N+1)]

distance = [INF] * (N+1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    # 거리는 모두 1

def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, now = heapq.heappop(queue)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + 1  # 거리는 1로 고정
            if cost < distance[i]:
                distance[i] = cost
                heapq.heappush(queue, (cost, i))

dijkstra(X)

answer = []

for i in range(1, N+1):
    if distance[i] == K:
        answer.append(i)

answer.sort()  # 오름차순 정렬

for i in answer:
    print(i)
if len(answer) == 0:  # 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1
    print(-1)
