import sys
import heapq
n,d = map(int, input().split())
data = [[] for _ in range(d+1)]
INF = 1e9
distance = [INF]*(d+1) # 최댓값으로 설정

for i in range(d):
    data[i].append((i+1, 1)) # 일단 초기 거리값 1로 모두 설정

for i in range(n):
    a,b,c = map(int, input().split()) 
    if b > d: # 만약 도착위치가 거리보다 크면 넘긴다.
        continue
    data[a].append((b,c))
q = []
heapq.heappush(q,(0,0))
distance[0] = 0

# 최단거리 코드 실행
while q:
    nd,e = heapq.heappop(q)

    if nd > distance[e]:
        continue

    for i in data[e]:
        cost = nd + i[1]

        if cost < distance[i[0]]:
            distance[i[0]] = cost
            heapq.heappush(q,(cost,i[0]))
print(distance[d])





#----------------------------------------------------------------------
#방법 2 dp?사용
import sys

n, d = map(int, sys.stdin.readline().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dis = [i for i in range(d+1)] # 각 인덱스마다의 거리로 설정 ex) 50 -> 50, 68->68

for i in range(d+1):
    dis[i] = min(dis[i],dis[i-1]+1) # 지름길을 선택할지 아니면 전의 값의다가 +1을 할지 최솟값을 설정한다. 

    for s,e,nd in graph: # 입력값을 돌면서
        if e<=d and i == s and dis[s]+nd < dis[e]: # 도착위치가 거리보다 작고 거리랑 시작값이 같고 지름길을 계산한 값이 도착한 위치의 값보다 작으면 값을 바꿔준다
            dis[e] = dis[s]+nd 
print(dis[d])            