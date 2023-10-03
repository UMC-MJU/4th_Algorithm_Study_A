# https://www.acmicpc.net/problem/2839

suger = int(input())
left = suger % 5    # 5킬로 봉지로 포장하고 남은 양

# 5킬로 봉지 수 기준 거꾸로 반복문
for i in reversed(range(suger//5+1)):
    left = suger - 5*i

    if left % 3 == 0:
        print(i+int(left/3))
        exit()  # 완전히 종료

print(-1)


