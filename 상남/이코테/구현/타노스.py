import sys
input = sys.stdin.readline
n = list(input())


zeron = n.count("0") # 0 갯수 세기
onen = n.count("1") # 1 갯수 세기

halfzero = zeron // 2 # 0 절반 갯수 구하기
halfone = onen // 2 # 1 절반 갯수 구하기

# 1부터 제거
cnt = 0
for i in range(len(n)): # 1은 앞에서부터 제거
    if n[i] == "1":
        n[i] = False    # 1을 만나면 false로
        cnt += 1
    
    if cnt == halfone:
        break
cnt = 0
# 0 제거
for i in range(len(n)-1,0,-1): # 0은 뒤에서부터 제거
    # print(n[i])
    if n[i] == "0":
        n[i] = False # 0을 만나면 false로
        cnt += 1
    
    if cnt == halfzero:
        break

for i in n:
    if i == "0" or i == "1": # 0과 1출력
        print(i, end= "")

