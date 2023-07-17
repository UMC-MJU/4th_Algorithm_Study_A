n = int(input())

data = [0] * 1000001 # 예외처리, n=1일 경우를 생각하지 않기위해 처음부터 n의 최댓값의 대한 메모리를 만든다.

data[1] = 1
data[2] = 2

for i in range(3,n+1):
    data[i] = (data[i-1] + data[i-2])  % 15746 # 메모리초과를 막기위해 15746을 사용한다.

print(data[n])

#수정