from itertools import permutations
n = int(input())

data = [list(map(int, input().split())) for _ in range(n)]
items = [1,2,3,4,5,6,7,8,9]
i_list = list(permutations(items,3)) # 순열로 만들어줍니다.
cnt = 0
for i in i_list:
    flag = 0
    for j in range(n):
        num_data = list(map(int,str(data[j][0]))) # data를 쪼갭니다

        s = 0
        b = 0
        for k in range(3):
            if i[k] == num_data[k]: # 한자리씩 비교를 합니다.
                s += 1
            elif i[k] in num_data:
                b += 1

        if s != data[j][1] or b != data[j][2]: # 다르면 0
            flag = 0
            break
        else:   # 같으면 1
            flag = 1

    if flag == 1:
        cnt += 1

print(cnt)
