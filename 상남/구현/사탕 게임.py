import sys
input = sys.stdin.readline
n = int(input())
data = [list(input()) for _ in range(n)]
max_cnt = 0
def check():
    global max_cnt
    for k in range(n):
        cnt = 1
        for t in range(n):
            if t < n - 1:
                if data[k][t] == data[k][t+1]:
                    cnt += 1
                    max_cnt = max(max_cnt, cnt)
                else:
                    cnt = 1
                # print(cnt,k,t)
    for k in range(n):
        cnt = 1
        for t in range(n):
            if t < n - 1:
                if data[t][k] == data[t + 1][k]:
                    cnt += 1
                    max_cnt = max(max_cnt, cnt)
                else:
                    cnt = 1


for i in range(n):
    for j in range(n):
        # 행
        if j >=0 and j< n-1:
            data[i][j],data[i][j+1] = data[i][j+1],data[i][j]
            check()
            data[i][j+1], data[i][j] = data[i][j], data[i][j+1]

        # 열
        if i>=0 and i< n-1:
            data[i][j],data[i+1][j] = data[i+1][j],data[i][j]
            check()
            data[i+1][j], data[i][j] = data[i][j], data[i+1][j]

print(max_cnt)