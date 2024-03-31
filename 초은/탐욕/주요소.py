# https://www.acmicpc.net/problem/13305

n = int(input())
roads = list(map(int, input().split()))
costs = list(map(int, input().split()))

count = 0
m = costs[0]
for i in range(n - 1):
    if costs[i] < m:
        m = costs[i]
    count += m * roads[i]

print(count)
