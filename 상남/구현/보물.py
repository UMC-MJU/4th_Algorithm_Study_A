n = int(input())

dataA = list(map(int,input().split()))
dataA.sort() # 정렬하기 오름차순
dataB = list(map(int,input().split()))
dataB.sort(reverse = True) # 정렬하기 내림차순

sum = 0

for i in range(len(dataA)):  
    sum += dataA[i]*dataB[i]    #오름차순한거랑 내림차순한거랑 곱해서 더한다.

print(sum)

