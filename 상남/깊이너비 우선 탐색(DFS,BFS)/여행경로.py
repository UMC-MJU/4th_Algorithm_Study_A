from collections import deque
def solution(tickets):
    que = deque()
    que.append(("ICN", ["ICN"], []))
    tickets.sort()
    answer = []
    while que:
        start, path, check = que.popleft()
        
        if len(check) == len(tickets):
            return path
            # answer.append(path)
        for idx,ticket in enumerate(tickets):
            if ticket[0] == start:
                if idx not in check:
                    que.append((ticket[1], path+[ticket[1]], check + [idx]))
    # return answer[0]
print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))