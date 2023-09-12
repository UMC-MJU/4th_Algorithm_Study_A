n = int(input())

dataA = list(map(int,input().split()))
dataA.sort()
dataB = list(map(int,input().split()))
dataB.sort(reverse = True)

sum = 0

for i in range(len(dataA)):
    sum += dataA[i]*dataB[i]

print(sum)

