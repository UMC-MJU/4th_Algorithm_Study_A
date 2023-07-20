# https://www.acmicpc.net/problem/1753

import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)  # int 범위내에서 무한대 값을 나타내기 위해 사용
N, M = map(int, input().strip().split())    # 정점의 개수, 간선의 개수
start = int(input())    # 시작 정점 번호

graph = [[] for _ in range(N + 1)]  # 간선 저장 2차원 배열
distance = [INF] * (N + 1)

for i in range(N):  # 간선 방향과 가중치 저장
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


dijkstra(start)

# 지나왔던 가중치 출력
for i in range(1, N + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])