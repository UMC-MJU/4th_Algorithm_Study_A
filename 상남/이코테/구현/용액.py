# 이분탐색
n = int(input())
data = list(map(int, input().split()))

lt = 0
rt = n-1
tmp = abs(data[lt]+data[rt])
a,b = 0,0
while lt < rt:
    if abs(data[lt]+data[rt]) <= tmp:
        a,b = data[lt], data[rt]
        tmp = abs(data[lt]+data[rt])
        if data[lt] + data[rt] == 0:
            break
    # if data[lt] + data[rt] == 0:
    #     break
    if data[lt]+data[rt] < 0:
        lt += 1
    else:
        rt -= 1

print(a,b)