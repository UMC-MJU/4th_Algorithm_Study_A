from heapq import heappush, heappop


def solution(n, k, enemy):
    answer = 0

    heap = []

    for idx, e in enumerate(enemy):
        heappush(heap, e)

        if len(heap) > k:
            print(heap)
            print(n)
            n -= heappop(heap)
            if n < 0:
                answer = idx
                break
            elif n == 0:
                answer = idx + 1
                break
    else:
        answer = idx + 1

    return answer