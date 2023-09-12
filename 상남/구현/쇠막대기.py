# 닫는 괄호가 나왔는데 전의 것이 ( 면 커트 --> pop을 진행하고 ( 의 개수를 셈
# 닫는 괄호가 나왔는데 전의 것이 ) 면 막대기의 끝부분? 이기 때문에 pop하고 +1
import sys
input = sys.stdin.readline
st = list(input())
tmp = []
prev = "" # 이전 것을 저장하는 변수
sum = 0
for t in st:

    if t == "(":
        tmp.append("(")
        prev = "(" # 전의 것 저장
    if t == ")":
        if prev == "(":
            tmp.pop()
            sum += len(tmp) # tmp 개수 더하기
        else:
            tmp.pop()
            sum += 1
        prev = ")"
print(sum)

# 접근법
# 처음에는 막막했다. 하지만 닫는괄호에서 어떤 처리가 이루어져야 할 것으로 생각했다.
# 고민해봐서 풀게됐다.