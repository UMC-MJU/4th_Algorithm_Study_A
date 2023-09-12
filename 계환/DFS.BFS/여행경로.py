#start = 시작 공항, idx = 인덱스(깊이)
answer = ["ICN"]
candidate = []
path = [[]]
def dfs(tickets, start, idx, visited):

    global answer

    num = 0  # 갈 수 있는 공항 개수
    destination = ''
    destination_num = 0
    global candidate
    global path

    for i in range(len(tickets)):
        # 출발 공항이 그 전 도착 공항과 같고 한 번도 방문하지 않은 경우
        if tickets[i][0] == start and not visited[i]:
            num += 1
            destination = tickets[i][1]
            destination_num = i
            visited[destination_num] = True
            candidate.append(destination)

            dfs(tickets, destination, idx+1, visited)
            path.append(candidate)
            # if num == 1:
            #     destination = tickets[i][1]
            #     destination_num = i
            # else:
            #     if destination > tickets[i][1]:
            #         destination = tickets[i][1]
            #         destination_num = i
    visited = [False] * len(tickets)

    if idx == len(tickets):  # 다 검색하면 return
        path.reverse()
        answer = path
        return

def solution(tickets):
    global answer
    visited = [False] * len(tickets)
    dfs(tickets, "ICN", 0, visited)
    return answer





#start = 시작 공항, idx = 인덱스(깊이)
answer = ["ICN"]
visited = [False]
def dfs(tickets, start, idx, visited):

    global answer
    num = 0  # 갈 수 있는 공항 개수 (후보)
    destination = ''
    destination_num = 0
    for i in range(len(tickets)):
        # 출발 공항이 그 전 도착 공항과 같고 한 번도 방문하지 않은 경우
        if tickets[i][0] == start and not visited[i]:
            num += 1
            if num == 1:
                destination = tickets[i][1]
                destination_num = i
            else:
                if destination > tickets[i][1]:
                    destination = tickets[i][1]
                    destination_num = i
    visited[destination_num] = True

    if destination != '':
        answer.append(destination)

    if idx == len(tickets):  #다 검색하면 return
        return

    dfs(tickets, destination, idx+1, visited)

def solution(tickets):
    global answer
    visited = [False] * len(tickets)
    dfs(tickets, "ICN", 0, visited)
    return answer