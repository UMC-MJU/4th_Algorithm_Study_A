import heapq
n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]

data.sort()

q = []
heapq.heappush(q,data[0][1])

for i in range(1,n):
    if data[i][0]< q[0]:
        heapq.heappush(q,data[i][0])
    else:
        heapq.heappop(q)
        heapq.heappush(q, data[i][0])
print(len(q))

