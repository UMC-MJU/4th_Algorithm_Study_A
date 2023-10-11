# https://www.acmicpc.net/problem/1697
import sys
from collections import deque

def bfs(v):
    q = deque([v])
    while q:
        # 가장 앞의 큐부터 pop
        v = q.popleft()
        # 동생과 위치 같아지면 종료
        if v == k:
            return array[v]
        # 한 칸씩 이동, 순간이동 3가지 모두 해보기
        for next_v in (v-1, v+1, 2*v):
            # 범위에 벗어나지 않고, 지나간 적이 없는 위치(이미 지나간 위치라면 그 후는 최소값이 아니므로)
            if 0 <= next_v < MAX and not array[next_v]:
                # 위치한 장소에 현재까지 계산한 횟수 저장
                array[next_v] = array[v] + 1
                q.append(next_v)


MAX = 100001
n, k = map(int, sys.stdin.readline().split())
array = [0] * MAX
print(bfs(n))