import heapq


def solution(book_time):
    data = []
    answer = 1

    for a, b in book_time:
        start = int(a[:2]) * 60 + int(a[3:])
        end = int(b[:2]) * 60 + int(b[3:])
        data.append([start, end])
    data.sort()
    heap = []
    for s, e in data:
        if not heap:
            heapq.heappush(heap, e + 10)
            continue
        if heap[0] <= s:
            heapq.heappop(heap)
        else:
            answer += 1

        heapq.heappush(heap, e + 10)
    return answer


solution([["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]])
solution([["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]])
