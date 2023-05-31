n = int(input())

data = [int(input()) for _ in range(n)]
rst = [0] * (n+1)
rst[0] = data[0]
if n == 1:
    pass
elif n == 2:
    rst[1] = data[0] + data[1]
else:
    rst[1] = data[0] + data[1]
    rst[2] = max(data[0]+data[1],
             data[0]+data[2],
             data[1]+data[2])
    for i in range(3,n):
        rst[i] = max(rst[i-2]+data[i],rst[i-3]+data[i-1]+data[i],rst[i-1])      #핵심 점화식
        # 1 4 7 10 1
print(rst[n-1])

# 1 --> rst[0] = data[0]
# 2 --> rst[1] = rst[0] + rst[1]
# 3 --> rst[2] = data[0] + data[2]