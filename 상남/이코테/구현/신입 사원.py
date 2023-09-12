# t = int(input())
# for _ in range(t):
#     n = int(input())
#     data = [list(map(int,input().split())) for _ in range(n)]
#     cnt = 0
#     for i in data:
#         for j in data:
#             if i[0] > j[0]:
#                 if i[1] > j[1]:
#                     break
#         else:
#             cnt += 1

#     print(cnt)

# 위에 코드는 시간초과 나요


t = int(input())
for _ in range(t):
    n = int(input())
    data = [list(map(int,input().split())) for _ in range(n)]
    data.sort()
    print(data)