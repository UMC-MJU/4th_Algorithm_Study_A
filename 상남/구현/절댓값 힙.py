# # from
# n = int(input())
# # data = [int(input()) for _ in range(n)]
# real = []
# juldaegabk = []
#
# for i in range(n):
#     tmp = int(input())
#     real.append(tmp)
#
#     if tmp < 0:
#         juldaegabk.append(-tmp)
#     else:
#         juldaegabk.append(tmp)
# print(real)
# print(juldaegabk)

import heapq
import sys
input = sys.stdin.readline
n = int(input())
q = []

for i in range(n):
    tmp = int(input())
    if tmp == 0:
        if len(q) == 0:
            print(0)
        else:
            print(heapq.heappop(q)[1])

    elif tmp < 0:
        heapq.heappush(q,[-tmp,tmp])
    else:
        heapq.heappush(q, [tmp,tmp])

# min heap을 사용해서 풀었다.