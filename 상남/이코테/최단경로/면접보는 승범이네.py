import sys
import heapq
input = sys.stdin.readline
n,m,k = map(int,input().split())


INF = 1e9
data = [[] for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int,input().split())
    data[a].append((b,c))

k = list(map(int, input().split()))
print(data)
for t in k:
    q = []
    distance = [INF for _ in range(n+1)]
    distance[t] = 0
    heapq.heappush(q,(0,t))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in data[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))

    print((distance))


# 못품