from collections import deque
n = int(input())
a,b = map(int, input().split())
data = [[] for _ in range(n+1)]
small = 1e9
rst = []

while a != -1 and b != -1:
    data[a].append(b)
    data[b].append(a)
    a,b = map(int, input().split())

for i in range(1,n+1):
    visited = [0 for _ in range(n+1)]
    q = deque()
    q.append(i)
    visited[i] = 1
    cnt = 1
    while q:
        tmp = q.popleft()

        for j in data[tmp]:
            if visited[j] == 0:
                visited[j] = visited[tmp] + 1
                q.append(j)

    tm = max(visited)
    rst.append(tm)
    if tm < small:
        small = tm
    # elif tm == big:
    #     cnt += 1
    # print(big,cnt)
cnt = 0
answer = []
for i in range(n):
    if rst[i] == small:
        answer.append(i+1)
print(small-1,len(answer))
for i in answer:
    print(i, end= " ")

# 예전에 풀었던 결혼식을 응용한 문제라고 생각한다.
# 1에서의 친구, 2에서의 친구 ... 을 구해주는게 핵심