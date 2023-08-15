# https://www.acmicpc.net/problem/1541

# 마이너스를 만나면 다음 마이너스까지 값 더하기
arr = input().split('-')
s = 0

# 첫 번째 마이너스 전까지는 다 더해주기
for i in arr[0].split('+'):
    s += int(i)

# 두 번째 마이너스부터는 더한 값 빼기
for i in arr[1:]:
    for j in i.split('+'):
        s -= int(j)
print(s)