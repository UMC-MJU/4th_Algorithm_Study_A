n = int(input())
data = [input() for i in range(n)]

data.sort(key = lambda  x : len(x)) # 1번조건 완료
for i in range(n):
    for j in range(i,n):
        if len(data[i]) == len(data[j]): # 2번 조건
            suma = 0
            sumb = 0
            for x,y in zip(data[i],data[j]):
                if x.isdigit():
                    suma += int(x)
                if y.isdigit():
                    sumb += int(y)

            if suma > sumb:
                data[i],data[j] = data[j],data[i]

            if suma == sumb:    # 3번 조건
                for x, y in zip(data[i], data[j]):
                    if x>y:

                        data[i],data[j] = data[j],data[i]
                        break
                        # 이걸해줘야하는이유는 반복문을 진행하면서 조건을 진행하면서 data[i],data[j] = data[j],data[i]를 또 수행하기 때문에
                    elif x<y:
                        # 이걸해줘야하는이유는 반복문을 진행하면서 조건을 진행하면서 data[i],data[j] = data[j],data[i]를 또 수행하기 때문에
                        break

for i in data:
    print(i)