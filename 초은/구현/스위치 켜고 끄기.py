# https://www.acmicpc.net/problem/1244
switch_num = int(input())
switches = [-1] + list(map(int, input().split()))
student_num = int(input())
def change(num):
    switches[num] = 1 - switches[num]

def boy():
    # 남학생 : 받은 번호의 배수만큼 스위치 상태 바꿈
    for i in range(n, switch_num + 1, n):
        change(i)

def girl():
    # 여학생 : 받은 번호 스위치 중심 좌우 대칭이면 상태 바꿈
    for i in range(switch_num // 2):
        # 범위를 벗어나거나 대칭이 아니면
        if n - i < 1 or n + i > switch_num:
            break
        if switches[n - i] != switches[n + i]:
            break
        else:
            change(n - i)
            change(n + i)
    change(n)

for _ in range(student_num):
    # 남학생은 1, 여학생은 2
    g, n = map(int, input().split())
    if g == 1:
        boy()
    else:
        girl()

# 출력
for i in range(1, switch_num+1):
    print(switches[i], end = " ")
    if i % 20 == 0 :
        print()