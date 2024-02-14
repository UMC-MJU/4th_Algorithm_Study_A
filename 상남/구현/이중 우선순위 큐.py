import heapq
import sys
input = sys.stdin.readline
t = int(input())
minq = []
maxq = []
for i in range(t):
    k = int(input())
    for j in range(k):
        a,b = input().split()
        b = int(b)

        if a == "I":
            heapq.heappush(minq,b)
            heapq.heappush(maxq,-b)
        else:
            if minq == [] and maxq == []:
                continue

            if b == 1:
                heapq.heappop(maxq)
            else:
                heapq.heappop(minq)
        print(maxq,minq)

    if minq == [] and maxq == []:
        print("EMPTY")
    else:
        print(-maxq[0],minq[0])