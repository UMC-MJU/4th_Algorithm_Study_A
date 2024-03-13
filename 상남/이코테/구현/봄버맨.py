r,c,n = map(int, input().split())

data = [(input()) for _ in range(r)]
d = [[0]*c for _ in range(r)]
i = 0
for tmp in data:
    j = 0
    for k in tmp:
        print("z",k)
        d[i][j] = k
        j += 1
    i += 1
print(data)
