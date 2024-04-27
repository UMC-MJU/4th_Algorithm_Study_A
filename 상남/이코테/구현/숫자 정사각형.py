n,m = map(int,input().split())
data = [list(map(int, input())) for _ in range(n)]
r = min(n,m)
rst = 0
for i in range(1,r):
    for j in range(n):
        if j+i<n:
            for k in range(m):
                if k+i<m:
                    if data[j][k] == data[j][k+i] and data[j][k] == data[j+i][k] and data[j][k+i] == data[j+i][k+i]:
                        rst = max(rst,i)
                else:
                    break
        else:
            break

print((rst+1)**2)