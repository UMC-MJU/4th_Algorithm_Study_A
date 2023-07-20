# 최소비용 구하기 ( https://www.acmicpc.net/problem/1916 )

import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)  # 무한을 표현

N = int(input())  # 도시의 개수
M = int(input())  # 버스의 개수

graph = [[] for _ in range(N+1)]  # 노드-간선 연결 정보

# 최소 비용 테이블을 모두 '무한'으로 초기화
costTable = [INF] * (N+1)

for i in range(M):
    # a = 출발 노드 / b = 도착 노드 / c = 비용
    a, b, c = map(int, input().split())
    graph[a].append((b,c))

# 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호
startCity, endCity = map(int, input().split())

def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))  # 시작 노드로 가기 위한 비용을 0으로 설정하여 큐에 삽입
    costTable[start] = 0

    while queue:
        cost, now = heapq.heappop(queue)  # 비용, 현재 노드 번호

        if costTable[now] < cost:
            continue

        # 현재 도시와 인접한 다른 도시들 확인
        for i in graph[now]:
            costTemp = cost + i[1]

            if costTemp < costTable[i[0]]:
                costTable[i[0]] = costTemp
                heapq.heappush(queue, (costTemp, i[0]))

# 다익스트라 알고리즘 실행
dijkstra(startCity)

print(costTable[endCity])


