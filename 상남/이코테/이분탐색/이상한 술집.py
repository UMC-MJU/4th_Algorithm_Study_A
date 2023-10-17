n,k = map(int, input().split())
data = [int(input()) for _ in range(n)]

lt = 1
rt = max(data)
rst = 0
while lt <= rt:
    mid = (lt + rt)//2
    cnt = 0
    for i in data:
        cnt += i //mid

    if cnt >= k:
        # if cnt == k: # 왜 이걸 하면 안되는지 모르겠음
        rst = mid
        lt = mid + 1
    else:
        rt = mid - 1

print(rst)