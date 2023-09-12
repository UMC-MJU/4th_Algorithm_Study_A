# https://www.acmicpc.net/problem/11404


import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)  # int 범위내에서 무한대 값을 나타내기 위해 사용
N = int(input())    # 도시의 개수
M = int(input())    # 버스의 개수

graph = [[] for _ in range(N + 1)]  # 버스 출발지, 도착지, 비용 저장할 2차원 배열 선언
distance = [INF] * (N + 1)

for i in range(M):  # 버스 출발지, 도착지, 비용 저장
    a, b, c = map(int, input().strip().split())
    graph[a].append((b, c))

def dijkstra(start):    # 다익스트라 알고리즘 사용
    q = []
    heapq.heappush(q, (0, start))   # 시작 정점에서 가중치 0으로 시작
    distance[start] = 0     # 시작 번째 배열 0으로 초기화

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:    # 이전에 지나갔던 기록이
                                    # 현재 반복문의 가중치보다 작으면 계속 할 필요X
            continue

        for i in graph[now]:    # 현재 정점이 가는 모든 길 탐색
            cost = dist + i[1]  # 현재 반복문 가중치 + 새로운 간선의 가중치
            if cost < distance[i[0]]:   # 이전에 지나갔던 기록보다 현재값이 더 작을 때
                distance[i[0]] = cost   # 기록 현재값으로 바꾸기
                heapq.heappush(q, (cost, i[0]))

# i번째 배열에 i번째 도시에서 출발하는 모든 도시까지들의 최소 거리 출력
for i in range(1, N + 1):
    dijkstra(i)
    print(*distance[1:])
    distance = [INF] * (N + 1)