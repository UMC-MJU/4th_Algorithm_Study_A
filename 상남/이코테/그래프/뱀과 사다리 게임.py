# from collections import deque
# n,m = map(int, input().split())
# # data = [list(map(int, input().split())) for _ in range(n+m)]
# dis = [i for i in range(101)]
# rst = [0 for _ in range(101)]
# for _ in range(n+m):
#     a, b = map(int, input().split())
#     dis[a] = b
#
# q = deque()
# q.append(1)
# rst[1] = 1
# while q:
#
#     tmp = q.popleft()
#     for i in range(1,7):
#         nt = tmp + i
#
#         if nt > 100:
#             break
#         cnt = dis[nt]
#         if rst[cnt] == 0:
#             rst[cnt] = rst[tmp] + 1
#             q.append(cnt)
#
#             if cnt == 100:
#                 print(rst[100]-1)
#                 exit()
# print(rst[100]-1)
#
#
#

from collections import deque
n,m = map(int, input().split())
# data = [list(map(int, input().split())) for _ in range(n+m)]
dis = [i for i in range(101)]
rst = [0 for _ in range(101)]
for _ in range(n+m):
    a, b = map(int, input().split())
    dis[a] = b

q = deque()
q.append(1)
rst[1] = 1
while q:
    tmp = q.popleft()

    if tmp == 100:
        break
    for i in range(1,7):

        nt = tmp + i
        if nt > 100:
            break
        if rst[nt] == 0:
            rst[dis[nt]] = rst[tmp] + 1
            q.append(dis[nt])


print(rst[100]-1)