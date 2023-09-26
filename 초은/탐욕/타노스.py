# https://www.acmicpc.net/problem/20310

str = input()

# 0과 1의 개수 저장
count_0 = str.count('0') // 2
count_1 = str.count('1') // 2
# 삭제할지, 안할지 나타내는 리스트
check = [True for _ in range(len(str))]

# 1은 앞에서부터 삭제
for i in range(len(str)):
    if count_1 > 0 and str[i] == '1':
        count_1 -= 1
        check[i] = False

# 0은 뒤에서부터 삭제
for i in range(len(str) - 1, -1, -1):
    if count_0 > 0 and str[i] == '0':
        count_0 -= 1
        check[i] = False

# 바로 붙여서 True인 것만 출력
for i in range(len(str)):
    if check[i]:
        print(str[i], end = '')

