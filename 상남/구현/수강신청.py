import sys
input = sys.stdin.readline
# 앞에서부터입력을 받는데 check에없으면 넣고 있으면 빼고 넣고
k,n = map(int, input().split())

check = {}
for i in range(n):
    tmp = str(input().rstrip())

    if tmp in check.keys():
        del(check[tmp])
        check[tmp] = tmp
    else:
        check[tmp] = tmp

# 만약 신청인원이 제한인원보다 적을경우
if (k > len(check)):
    # 제한 인원을 신청 인원과 동일하게 수정
    k = len(check)
cnt = 0
for i in check:
    if cnt == k:
        break
    print(i)
    cnt += 1
