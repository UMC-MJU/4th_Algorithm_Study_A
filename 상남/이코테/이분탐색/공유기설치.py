import sys

input = sys.stdin.readline
n,c = map(int,input().split())
data = [int(input()) for _ in range(n)]
data.sort()

lt = 1
rt = max(data)
res = 0
while lt<=rt:
    mid = (lt + rt) // 2
    cnt = 1
    start = min(data)
    for i in data:
        if i - start - mid >=0:
            start = i
            cnt += 1
    # print("z",cnt,lt,rt)
    if cnt >= c:
        lt = mid + 1
        res = mid
    else:
        rt = mid - 1
print(res)

#수정