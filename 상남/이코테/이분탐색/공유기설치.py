import sys

input = sys.stdin.readline
n,c = map(int,input().split())
data = [int(input()) for _ in range(n)]
data.sort() # data를 정렬

lt = 1
rt = max(data)
res = 0
while lt<=rt:
    mid = (lt + rt) // 2 # mid값을 구한 후
    cnt = 1
    start = min(data) # 시작은 data의 최솟값
    for i in data:
        if i - start - mid >=0: # 데이터 값에서 시작값을 빼고 미드값을 빼서 양수이면
            start = i # 시작값을 데이터 값으로 수정
            cnt += 1 # 개수증가
    # print("z",cnt,lt,rt)
    if cnt >= c: # 개수가 c를 초과해도 문제조건은 만족하므로 >= 이렇게 해주어야함
        lt = mid + 1
        res = mid
    else:
        rt = mid - 1
print(res)