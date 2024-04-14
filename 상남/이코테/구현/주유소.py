import sys
input = sys.stdin.readline
n = int(input())
km = list(map(int,input().split()))
price = list(map(int,input().split()))

total = 0
minPrice = price[0]
for i in range(n-1):
    if minPrice > price[i]:
        minPrice = price[i]
    total += km[i]*minPrice
print(total)