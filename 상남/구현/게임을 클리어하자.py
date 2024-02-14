import sys
input = sys.stdin.readline
n,m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
rst = [[0]*m for _ in range(n)]
for i in range(1,n):
    for j in range(m):
        if j == 0:
            data[i][0] += min(data[i-1][1:])
        elif j == m-1:

            data[i][m-1] += min(data[i-1][:m-1])
        else:
            data[i][j] += min(min(data[i-1][:j]),min(data[i-1][j+1:m]))

print(min(data[n-1]))

# 정수삼각형에서 살짝 달라진 문제라고 생각한다