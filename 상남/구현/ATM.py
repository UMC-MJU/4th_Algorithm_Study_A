n = int(input())
data = list(map(int,input().split()))
data.sort()
total = 0
rst = []
for i in data:
    total += i
    rst.append(total)
print(sum(rst))


