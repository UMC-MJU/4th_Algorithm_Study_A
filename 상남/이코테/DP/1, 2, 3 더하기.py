n = int(input())

data = [int(input()) for _ in range(n)] # 입력받기
 
for i in data: # 입력받은 데이터 값에서 하나씩 빼옴
    rst = [0]*11 #
    rst[1] = 1  # 초기데이터저장
    rst[2] = 2  # 초기데이터저장
    rst[3] = 4  # 초기데이터저장

    for j in range(4,i+1):
        rst[j] = rst[j-3] + rst[j-2] + rst[j-1] # 핵심적인 점화식이다.

    print(rst[i])
# dp느낌이나서 하나씩 구해봤더니 점화식이 세워졌다. 근데 왜 이렇게 점화식이 세워졌는지는 이해를 못했는데 구글링을 보고 이해했습니다.