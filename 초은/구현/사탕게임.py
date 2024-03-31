# https://www.acmicpc.net/problem/16953

# top-down 방식
a, b = map(int, input().split())
r = 1
while b != a:
    r += 1
    temp = b
    # 오른쪽 끝에 1이 존재하면 삭제
    if b % 10 == 1:
        b //= 10
    # 2로 나누어 떨어지면 2 나누기
    elif b % 2 == 0:
        b //= 2

    # 두 가지 모두 계산 불가일 때
    if temp == b:
        print(-1)
        break
else:
    print(r)
