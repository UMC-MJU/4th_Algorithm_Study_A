# from collections import deque
#
# t = int(input())
# dx = [-1,1,0,0]
# dy = [0,0,-1,1]
#
# def bfs(a,b):
#     # q = deque()
#     # q.append((a,b))
#     # visited[a][b] = True
#     #
#     #
#     # while q:
#     #     x,y = q.popleft()
#     #
#     #     for i in range(4):
#     #
#     #         nx = x + dx[i]
#     #         ny = y + dy[i]
#     #
#     #         if nx<0 or nx >=2 or ny<0 or ny>= n:
#     #             continue
#     #
#     #         if visited[nx][ny] == False:
#     #             visited[nx][ny] = True
#     #             q.append((nx,ny))
#     for i in range(4):
#         nx = a + dx[i]
#         ny = b + dy[i]
#
#         if nx<0 or nx >=2 or ny<0 or ny>= n:
#             continue
#
#         if visited[nx][ny] == False:
#             visited[nx][ny] = True
# for i in range(t):
#     n = int(input())
#     data = [list(map(int, input().split())) for _ in range(2)]
#
#
#     visited = [[False]*n for _ in range(2)]
#     cnt = 0
#
#     for i in range(2):
#         for j in range(n):
#             if visited[i][j] == False:
#                 cnt += data[i][j]
#                 bfs(i,j) # 닫아주기
#
#     print(cnt)
import sys
input = sys.stdin.readline
t = int(input())
for i in range(t):
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(2)]


    if n > 1:
        data[0][1] += data[1][0]
        data[1][1] += data[0][0]

    for i in range(2,n):
        data[0][i] += max(data[1][i-1],data[1][i-2])
        data[1][i] += max(data[0][i-1],data[0][i-2])
    print(max(data[0][n-1],data[1][n-1]))




