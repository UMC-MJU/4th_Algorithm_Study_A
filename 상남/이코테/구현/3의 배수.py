n = (input())
cnt = 0
while len(n) != 1: # n의 길이가 1자리가 아니면
    tmp = list(map(int,n)) # 숫자를 분해
    n = str(sum(tmp)) # 분해한 숫자들을 더한 후 스트링으로 변환
    cnt += 1
print(cnt)
if int(n) % 3 == 0 :
    print("YES")
else:
    print("NO")