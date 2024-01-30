import sys
input = sys.stdin.readline
t = int(input())
for i in range(t):
    n = int(input())
    data = list(map(int,input().split()))
    # data.sort(reverse = True)

    tmp = 0
    sum = 0
    for j in range(n-1,-1,-1):
        if tmp < data[j]:
            tmp = data[j]
            continue
        sum += tmp - data[j]
    print(sum)


# 순차적으로 하는 방법만 생각했지 거꾸로 돈다는 생각을 하지 못했다.