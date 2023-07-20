import heapq
v,e = map(int,input().split())

k = int(input())
INF = int(1e9) # 1e9는 max값
graph = [[] for _ in range(v+1)]

for _ in range(e):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

distance = [INF] * (v+1) # 노드의 개수를 편의상 맞게하기위해 v+1개의 inf를 만들어준다.

q = []
distance[k] = 0    # 시작지점은 0
heapq.heappush(q,(0,k)) #이번에 최단경로를 풀면서 알게된 개념이다. --> heapq = min heap을 다루는 함수로서 앞에 들어오는 인자를 우선을 둬 min heap을 진행하는 함수이다.

while q:
    dist, now = heapq.heappop(q)    # 거리와 노드 빼논다.

    if distance[now] < dist: # 현재의 거리가 빼논거리보다 짧으면 스킵한다.
        continue

    for i in graph[now]:    
        cost = dist + i[1]
        if cost < distance[i[0]]:    # 반복문을 진행시켜 거리가 더 짧으면 값을 변경해준다.
            distance[i[0]] = cost
            heapq.heappush(q,(cost,i[0]))
    

for i in range(1,v+1):
    if distance[i] == INF:    # inf를 걸러내기 위한 for문
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
