import sys
input = sys.stdin.readline
n,m = map(int, input().split())
data = [int(input()) for _ in range(m)]


lt = 1
rt = max(data) #data의 최댓값
rst = 0
while lt<=rt:
    mid = (lt+rt)//2 # 한 사람이 가져가는 보석의 수
    total = 0
    for i in data:
        if i%mid == 0: # 정확히 분배한다면
            total += i//mid 
        else:
            total += i//mid + 1 #아니라면 +1을해 1개 더 추가 ex) 5개, 3개이면 2개 3개로 나누기 때문에 5//3 + 1
    
    if total > n: # 너무 많이 나눠진다면
        lt = mid + 1
    else:
        rst = mid
        rt = mid - 1
print(rst)