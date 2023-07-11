n = int(input())
datan = list(map(int, input().split()))
m = int(input())
datam = list(map(int, input().split()))

datan.sort()

for find in datam: # datam에서 데이터 하나씩 가져옴
    
    rst = False
    s = 0
    e = len(datan) - 1  # 데이터 길이 가져오기
    while s <= e :
        mid = (s + e) // 2  # mid 구하기
        if datan[mid] == find:
            rst = True
            break
        elif datan[mid] > find:
            e = mid - 1 
        else:
            s = mid + 1
    
    if rst == True:
        print(1)
    else:
        print(0)

