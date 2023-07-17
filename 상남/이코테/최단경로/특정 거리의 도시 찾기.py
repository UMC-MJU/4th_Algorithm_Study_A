import heapq
import sys

input = sys.stdin.readline
n,m,k,x = map(int, input().split())

INF = 1e9 # max값 설정
graph = [[] for _ in range(n+1)] # graph 입력값 받기를 위한 리스트

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b) # graph 입력 받기
distance = [INF for _ in range(n+1)] # 거리를 저장하기위한 리스트 and 방문처리도 해주는 리스트
distance[x] = 0

q = []
heapq.heappush(q,(0,x))

while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
        continue

    for i in graph[now]:
        cost = dist + 1 # 거리 1 증가하여 비교한다.
        if cost < distance[i]:
            distance[i] = cost
            heapq.heappush(q,(cost,i))




ch = False
for idx,rst in enumerate(distance): # 만약 if문안에 들어가지않으면 k값에 맞는 값이 없다라고 접근했다
    if rst == k:
        ch = True
        print(idx)

if ch == False:
    print(-1)

#수정