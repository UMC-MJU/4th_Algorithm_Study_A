n,k = map(int, input().split())
data = list(map(int,input().split()))
lt,rt = 0,0
rst = 0
cnt = 0
check = [0] *100001
while rt< n:
    if check[data[rt]] <k:
        check[data[rt]] += 1
        rt += 1
        cnt += 1
    else:
        rst = max(rst,cnt)
        check[data[lt]] -= 1
        lt += 1
        cnt -= 1
    rst = max(rst, cnt)
print(rst)