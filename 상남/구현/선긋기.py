import sys
input = sys.stdin.readline
n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
# print(data)
data.sort(key = lambda x : (x[0], x[1]))

small = data[0][0]
big = data[0][1]
cnt = 0
for i in range(1, n):
    a,b = data[i][0], data[i][1]
    if big >= a: # 선이 겹치는 경우
        # print(big,a)
        if big < b:
            big = b

    elif big < a: # 선이 끊기는 경우
       cnt += big - small
       small = a
       big = b
print(cnt+big-small)

# 그림 그리면서 언제 선을 계산하는지 조건을 구했다.