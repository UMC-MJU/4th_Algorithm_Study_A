import sys
input = sys.stdin.readline
n,m = map(int, input().split())
data = [int(input()) for _ in range(n)]

lt = 1
rt = sum(data)

while lt<=rt:

    mid = (lt+rt) // 2
    cnt = 1
    tmp = mid
    for i in data:
        if tmp - i < 0:
            cnt += 1
            tmp = mid
        
        tmp = tmp - i

    if cnt > m:
    #  if num > m or mid < max(data):    ->	mid < max(data) 이 코드를 작성해줘야 정답처리가 된다. 왜 해줘야하는지 아직도 모르겠다.
        lt = mid + 1
    else:
        rt = mid - 1
        rst = mid

print(rst)