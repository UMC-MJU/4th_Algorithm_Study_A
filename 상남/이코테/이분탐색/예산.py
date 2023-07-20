n = int(input())
data = list(map(int, input().split()))
m = int(input())


lt = 0
rt = max(data) #data값에서 가장 큰값 가져오기

res = 0

while lt<=rt:
    mid = (lt + rt) // 2
    sum = 0
    for i in data: # data안에서 값 가져오기

        if i >= mid:    
            sum += mid
        else:
            sum += i
    
    if sum > m:
        rt = mid -1
    elif sum <= m:
        lt = mid + 1
        res = mid # 일단 sum이 m보다 작으면 결과에 충족하는거니 일단 저장한다.

print(res)