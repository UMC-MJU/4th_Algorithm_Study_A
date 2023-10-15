def d(i):
    next = i
    for i in list(str(next)): # 숫자를 쪼갠다 --> 213 => 2,1,3
        next += int(i) # => 213+2+1+3
    return next
s = []
for i in range(1,10001):
    s.append(d(i))
for i in range(1,10001):
    if i in s:
        continue
    else:
        print(i)