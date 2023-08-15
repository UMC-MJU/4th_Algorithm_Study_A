#하나 넣어주고 하나빼주고를 합이 큰곳을 기준으로 해주면 된다.
from collections import deque
def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    que1sum = sum(queue1)
    que2sum = sum(queue2)
    avg = (que1sum + que2sum) // 2
    answer = 0
    check = False
    #sum 함수를 쓰면 시간초과뜸;; 그래서 일일히 다 계산해줘야한다.
    for _ in range(len(queue1)*4): #숫자가 2개이면 최대 8번은 탐색한다 그래서 최대 *4를 해준것
        if que1sum > que2sum:
            que1sum -= queue1[0]
            que2sum += queue1[0]
            queue2.append(queue1.popleft())
            answer += 1
        elif que1sum < que2sum:
            que1sum += queue2[0]
            que2sum -= queue2[0]
            queue1.append(queue2.popleft())
            answer += 1
        # answer += 1 여기다가 바로 해버리면 수행을 하지 않을 때 틀리게 됨
        if avg == (que1sum) and avg == sum(que2sum):
            check = True
            break
    if check == True:
        return answer
    else:
        return -1
print(solution([3, 2, 7, 2],[4, 6, 5, 1]))