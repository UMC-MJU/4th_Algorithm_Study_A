# https://www.acmicpc.net/problem/10845

import queue
import sys

queue = queue.Queue()
N = int(input())

for _ in range(N):
    command = sys.stdin.readline().split()

    if command[0] == 'push':
        queue.put(command[1])

    elif command[0] == 'pop':
        print(queue.get() if not queue.empty() else -1)

    elif command[0] == 'size':
        print(queue.qsize())

    elif command[0] == 'empty':
        print(1 if queue.empty() else 0)

    elif command[0] == 'front':
        print(queue.queue[0] if not queue.empty() else -1)

    elif command[0] == 'back':
        print(queue.queue[-1] if not queue.empty() else -1)


