n = int(input())

data = list(map(int, input().split()))
x = int(input())


data.sort() # 정렬
 
lt = 0 # 맨 왼쪽
rt  = len(data) - 1 # 맨 오른쪽
cnt = 0

while lt < rt: # 같다를 하면 안된다. 만약 x--> 10일 때 5를 두번 더해서 cnt+1을 할 수 있기 때문에
    num = data[lt] + data[rt] # 양쪽 더한다
    if num == x: # 일치하면 왼쪽은 올리고 오른쪽은 내린다
        cnt += 1
        lt += 1
        rt -= 1
    elif num > x: # 값이 너무 크면 오른쪽값을 내려서 값을 나춘다.
        rt -= 1
    else:
        lt += 1 # 값이 너무 작으면 왼쪽값을 올려서 값을 올린다.
print(cnt)