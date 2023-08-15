from collections import deque
n,w,l = map(int, input().split())
data = list(map(int,input().split()))

q = deque(data)
cnt = 0
rst = []
bridge = [0] * w
# while len(rst) != n:
#     print(rst)
#     tmp = q.popleft()
#     bridge.append(tmp)
#     cnt += 1    #1->3
#     sum = tmp   
#     for _ in range(1,w):
#         if q:
#             if q[0] + sum <= l:
#                 cnt += 1  #4
#                 sum += q[0]
#                 bridge.append(q[0])
#             else:
#                 cnt += 1#2
#                 rst.append(bridge.popleft())
        
    

while bridge:
    cnt += 1
    bridge.pop(0)

    #트럭이 있는지
    if q:
        if sum(bridge) + q[0] > l:
            bridge.append(0)    # 빈공간 추가
        else:
            bridge.append(q.popleft()) # 다리에 트럭추가

print(cnt)