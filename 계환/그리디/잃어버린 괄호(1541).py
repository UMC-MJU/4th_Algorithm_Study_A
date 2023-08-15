# 잃어버린 괄호 https://www.acmicpc.net/problem/1541

import sys
input = sys.stdin.readline

# 문제의 포인트는 첫 '-'가 나올 때까지는 모두 더하고 그 뒤로는 모두 빼는 것이다.
# '-'를 기준으로 쪼개서 입력받는다.
list = input().split('-')
sum = 0

# list[0]값은 '-'가 나오기 전까지의 숫자들이다. 모두 더해준다.
for i in list[0].split('+'):
    sum += int(i)

# list의 1번째 인덱스부터의 값은 '-'가 나오고 난 후의 숫자들이다. 모두 빼준다.
for i in list[1:]:
    for j in i.split('+'):
        sum -= int(j)

print(sum)
