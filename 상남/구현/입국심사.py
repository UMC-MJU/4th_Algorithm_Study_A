import sys
input = sys.stdin.readline
n,m = map(int, input().split())
data = [int(input()) for _ in range(n)]
lt = 1
rt = max(data) * m
data.sort()
ans = 1e9
while lt <= rt:
 cnt = 0
 mid = (lt + rt)//2
 for i in range(n):
  if cnt >= m:
   break
  cnt += mid//data[i]

 if cnt >= m :
  rt = mid -1
  ans = min(ans,mid)
 else:
  lt = mid + 1
print(ans)