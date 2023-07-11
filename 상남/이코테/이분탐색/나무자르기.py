n,m = map(int,input().split())
data = list(map(int,input().split()))

st = 0
ed = max(data)
res = 0

while st<=ed:

    sum = 0
    mid = (st+ed)//2

    for i in data:
        if i > mid:
            sum += i - mid # 나무를 자른다.
    
    if sum >= m:
        st = mid + 1 # 오른쪽에서 이분탐색
        res = mid 

    elif sum < m:
        ed = mid - 1 # 왼쪽에서 이분탐색
    
print(res)

# 시작이 왜 0인지모르겠습니다.