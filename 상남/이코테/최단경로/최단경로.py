import heapq
v,e = map(int,input().split())

k = int(input())
INF = int(1e9)
graph = [[] for _ in range(v+1)]

for _ in range(e):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

distance = [INF] * (v+1)

q = []
distance[k] = 0
heapq.heappush(q,(0,k))

while q:
    dist, now = heapq.heappop(q)

    if distance[now] < dist:
        continue

    for i in graph[now]:
        cost = dist + i[1]
        if cost < distance[i[0]]:
            distance[i[0]] = cost
            heapq.heappush(q,(cost,i[0]))
    

for i in range(1,v+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])



























# from cmath import inf
# import sys
# import heapq

# v,e = map(int, sys.stdin.readline().rstrip().split())
# INF = int(1e9)
# k = int(sys.stdin.readline().rstrip())
# graph = [[] for _ in range(v+1)]
# distance = [INF] * (v + 1)

# for _ in range(e):
#     u, b, w = map(int, sys.stdin.readline().rstrip().split())
#     graph[u].append((b,w))
# print(graph)
# def dijkstra(start):
#     q = []
#     distance[start] = 0
#     heapq.heappush(q, (0, start))

#     while q:
#         dist, now = heapq.heappop(q)

#         if distance[now] < dist:
#             continue

#         for i in graph[now]:
#             cost = dist + i[1]

#             if cost < distance[i[0]]:
#                 distance[i[0]] = cost
#                 heapq.heappush(q, (cost, i[0]))

# dijkstra(k)

# for i in range(1, v+1):
#     if distance[i] == INF:
#         print("INF")
#     else:
#         print(distance[i])
