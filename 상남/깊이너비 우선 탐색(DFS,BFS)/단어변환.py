from collections import deque
def solution(begin, target, words):
    visited = [False] * len(words)
    cnt = 0
    que = deque()
    que.append([begin,cnt])
    while que:
        word, cnt = que.popleft()
        if word == target:
            return cnt
        for i in range(len(words)):
            tmpcnt = 0 
            if visited[i] == False:
                for j in range(len(word)):
                    if word[j] != words[i][j]:
                        tmpcnt += 1

                if tmpcnt == 1:
                    que.append([words[i],cnt+1])
                    visited[i] = True
    return cnt
print(solution("hit","cog",["hot", "dot", "dog", "lot", "log", "cog"]))