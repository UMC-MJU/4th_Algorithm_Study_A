n = 1
def dfs(v,cnt):
    if v == 6:
        for i in tmp:
            print(i, end = " ") # tmp 변수들 출력
        print()    
    else:
        for i in range(cnt,p): # 백트래킹 실행 -> tmp변수에 뿌리를 내리는 방식
            tmp[v] = data[i]
            dfs(v+1,i+1)


while n != 0:
    data = list(map(int, input().split()))
    p , data = data[0],data[1:] # 첫번째값과 나머지 데이터값들을 슬라이싱함
    if p == 0:
        break
    tmp = [0]*6
    dfs(0,0)
    print()
    
