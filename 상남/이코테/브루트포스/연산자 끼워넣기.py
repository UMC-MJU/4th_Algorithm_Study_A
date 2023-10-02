# n = int(input())
# data = list(map(str, input().split()))
# operator = list(map(str, input().split()))
#
# op = ["+","-","*","/"]
# def dfs(v,l,tmp):
#     if v == n:
#         pass
#
#     for i in range(n-1):
#         tmp = tmp + data[v]
#         if operator[i] != 0:
#             dfs(v+1,l+1,tmp+data[v]+operator[i])
#             operator[i] -= 1
#
#
#
# dfs(0,0,"")

n = int(input())
data = list(map(int, input().split()))
operator = list(map(int, input().split()))

big = -1e9
small = 1e9
def dfs(v,total,plus,minus,multiply,divide):
    global big, small
    if v == n: #최소,최대값 구하기
        big = max(total,big)
        small = min(total,small)
        return

    if plus: #플러스 값이 남아있으면
        dfs(v+1,total+data[v],plus-1,minus,multiply,divide)
    if minus: #마이너스 값이 남아있으면
        dfs(v+1,total-data[v],plus,minus-1,multiply,divide)
    if multiply: #곱하기 값이 남아있으면
        dfs(v+1,total*data[v],plus,minus,multiply-1,divide)
    if divide: #나누기 값이 남아있으면
        dfs(v+1,int(total/data[v]),plus,minus,multiply,divide-1)

dfs(1,data[0],operator[0],operator[1],operator[2],operator[3])
print(big,small)

# n = int(input())
# m = int(input())
#
# print(int(n/m))
# print(n//m)

# -333
# 4
# -83
# -84
