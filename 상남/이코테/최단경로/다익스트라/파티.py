import heapq
import sys
input = sys.stdin.readline
n,m,x = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(m)]

graph = [[] for _ in range(n+1)]

for start,end,t in data:
    graph[start].append([end,t])

INF = 1e9 # 최댓값

def dik(start):
    distance = [INF] * (n + 1)

    q = []

    heapq.heappush(q, [0, start])
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = i[1] + dist
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,[cost,i[0]])
    return distance
rst = 0
for i in range(1, n+1):
    go = dik(i) # i에서 각 노드끼리의 최단거리
    back = dik(x) # x에서 각 노드끼리의 최단거리

    rst = max(rst,go[x]+back[i]) # i에서 x까지의 최단거리 + x에서 i까지의 최단거리

# 바로 위 반목문을 생각하는게 이번문제의 핵심 로직

print(rst)