n = int(input())

# DP 테이블 초기화
d = [0] * 1000001
path = [""] * 1000001
path[1] = "1"
# 다이나믹 프로그래밍 진행(bottom-up)
for i in range(2, n+1):
    # 현재의 수에서 1을 빼는 경우
    d[i] = d[i-1] + 1
    prev = i-1
    # 현재의 수가 2로 나누어 떨어지는 경우
    if i%3 == 0 and d[i] > d[i//3] + 1:
        d[i] = min(d[i], d[i//3] + 1)
        prev = i // 3
    if i%2 == 0 and d[i] > d[i//2] + 1:
        d[i] = min(d[i], d[i//2] + 1)
        prev = i // 2
    # 현재의 수가 3으로 나누어 떨어지는 경우
    path[i] = str(i) + " " + path[prev]
# 결과 출력
print(d[n])
print(path[n])
