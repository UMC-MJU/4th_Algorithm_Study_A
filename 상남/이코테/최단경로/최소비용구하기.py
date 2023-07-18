import sys
import heapq
INF = 1e9
input = sys.stdin.readline  
n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
st,ed = map(int,input().split())

# 여기까지 입력부분

distance = [INF for _ in range(n+1)]    # 비용을 구하기 위한 리스트
q = []
heapq.heappush(q,(0,st))    # MIN HEAP을 이용하여 진행한다.

while q:
    dist, now = heapq.heappop(q)

    if distance[now] < dist:    # 원래 비용보다 많으면 넘긴다.
        continue

    for i in graph[now]:    # 해당 노드값에 비용을 탐색
        cost = i[1] + dist

        if cost < distance[i[0]]:   # 해당 노드값의 비용이 많으면 새로온 것으로 바꿔준다
            distance[i[0]] = cost
            heapq.heappush(q,(cost,i[0]))

print(distance[ed])

#수정1