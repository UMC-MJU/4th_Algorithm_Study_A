def solution(m, n, puddles):
    data = [[0]*(m+1) for i in range(n+1)]
    data[1][1] = 1           # 집의 위치(시작위치)
    for i, j in puddles: # 웅덩이가 있는 곳은 -1로 표시
        data[j][i] = -1
    for i in range(1,n+1):
        for j in range(1,m+1):
            if i == 1 and j == 1: continue
            if data[i][j] == -1: # 웅덩이이면
                data[i][j] = 0 # 이후 값에 영향을 주지 않게 하기 위해 0으로 바꾸고
            else:
                data[i][j] = (data[i-1][j] + data[i][j-1])%1000000007
    return (data[n][m])