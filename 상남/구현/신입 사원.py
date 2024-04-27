import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    data.sort()
    cnt = 1

    tmp = data[0][1]
    for i in range(1,n):
        # for j in range(i):
        #     if data[i][1] >data[j][1]:
        #         # print(data[i][1] ,data[j][1])
        #         cnt -= 1
        #         break
        if tmp > data[i][1]:
            cnt += 1
            tmp = data[i][1]

    print(cnt)



