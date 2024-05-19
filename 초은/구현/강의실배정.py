# https://www.acmicpc.net/problem/11000

T = int(input())
data = [list(map(int, input().split())) for _ in range(T)]
data.sort()
count = T

for i in range(T):
    if data[i][0] != -1:
        for j in range(i + 1, T):
            if data[j][0] != -1:
                if data[i][1] <= data[j][0]:
                    data[i][1] = data[j][1]
                    data[j] = [-1, -1]
                    count -= 1
print(count)
