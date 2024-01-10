# 시간초과남
# n = int(input())
# data = [list(map(int,input().split())) for i in range(n)]
#
# # 앞에 기준 정렬
# for i in range(len(data)):
#     if data[i-1][0] > data[i][0]:
#         for j in range(i,0,-1):
#             if data[j-1][0] > data[j][0]:
#                 tmp = data[j-1][0]
#                 data[j-1][0] = data[j][0]
#                 data[j][0] = tmp
#
#                 tmp = data[j-1][1]
#                 data[j-1][1] = data[j][1]
#                 data[j][1] = tmp
#
# # 앞에 기준 정렬 후 뒤에기준정렬
# for i in range(len(data)):
#     if data[i-1][1] > data[i][1]:
#         for j in range(i,0,-1):
#             if data[j-1][1] > data[j][1]:
#                 tmp = data[j-1][1]
#                 data[j-1][1] = data[j][1]
#                 data[j][1] = tmp
#
#                 tmp = data[j-1][0]
#                 data[j-1][0] = data[j][0]
#                 data[j][0] = tmp
# rst = data[0][1]
# cnt = 1
# for i in range(len(data)):
#     if data[i][0] >= rst:
#         rst = data[i][1]
#         cnt += 1
# print(cnt)
n = int(input())
data = [list(map(int,input().split())) for i in range(n)]

data.sort() # 앞을 기준으로 정렬
data.sort(key = lambda x: x[1]) # 앞 기준 정렬 후 뒤를 기준으로 정렬
# data의 상태는 앞이 우선이 되지만 뒤에가 작은순으로 정렬이 되기때문에
# 뒤에 값을 보면서 시간을 이어가면됨

rst = data[0][1] # 첫번째값의 뒷값을 가져옴
cnt = 1
for i in range(len(data)):
    if data[i][0] >= rst: #
        rst = data[i][1]
        cnt += 1
print(cnt)




