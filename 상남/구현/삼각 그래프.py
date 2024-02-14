l = -1
cnt = 0
n = int(input())
while n != 0:
    data = [list(map(int,input().split())) for _ in range(n)]
    data[1][0] += data[0][1]
    data[1][1] += min(data[0][1]+data[1][0], data[0][1],data[0][1]+data[0][2])
    data[1][2] += min(data[0][1]+data[0][2], data[0][1],data[0][1] + data[1][1])

    for i in range(2,n):
        for j in range(3):
            if j == 0:
                data[i][0] += min(data[i-1][0],data[i-1][1])
            elif j == 1:
                data[i][1] += min(data[i-1][0],data[i-1][1],data[i-1][2])
            elif j == 2:
                data[i][2] += min(data[i - 1][1], data[i - 1][2])
    n = int(input())
    cnt += 1

    print(str(cnt)+". "+str(data[n-1][1]))
# print(data)
