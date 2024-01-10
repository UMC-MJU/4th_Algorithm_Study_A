import math
m,n = map(int, input().split())
def isSosu(num):
    if num == 1:
        return False
    n = int(math.sqrt(num))
    for i in range(2,n+1):
        if num % i == 0:
            return False
    return True

for i in range(m,n+1):
    if isSosu(i):
        print(i)