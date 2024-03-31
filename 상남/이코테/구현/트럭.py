from collections import deque

n,w,l = map(int, input().split())
data = list(map(int, input().split()))

q = deque(data)
bridge = [0] * w

cnt = 0
while bridge:
    cnt += 1
    bridge.pop(0)

    if q:
        if q[0]+sum(bridge) > l:
            bridge.append(0)
        else:
            bridge.append(q.popleft())
print(cnt)