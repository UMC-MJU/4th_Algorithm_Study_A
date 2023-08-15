# https://www.acmicpc.net/problem/13335

N, W, L = map(int, input().split())
trucks = list(map(int, input().split()))
time = 0
stack = []

for truck in trucks:
    stack.append(truck)

    if sum(stack) > L:  # 무게 초과하면 스택에 있던 값 하나 빼고 계산
        tmp = stack.pop()
        # 다리 길이, 한번에 지나간 트럭 수 - 1 만큼 더하기
        time += W + len(stack) - 1
        # 빼뒀던 값 스택 초기화 수 다시 넣기
        stack = [tmp]

# 가장 마지막 트럭엔 -1을 할 필요X, 끝까지 건너는 시간이 필요하기 때문
print(time + W + len(stack))

# 제출하면 틀렸다고 나오는데 어디가 문제인지 모르겠네요,,,