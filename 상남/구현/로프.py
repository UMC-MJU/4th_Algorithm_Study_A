import sys
input = sys.stdin.readline
n = int(input())
data = [int(input()) for _ in range(n)]
data.sort(reverse = True)

rst = 0
for k in range(1,n+1):
    tmp = data[k-1]
    rst = max(rst,tmp*k)
print(rst)
# 수학적으로 접근해봤다