k,s,n = input().split()
n = int(n)
data = [input() for _ in range(n)]

mx = {
    "R" : [1,0],
    "L" : [-1,0],
    "B" : [0,-1],
    "T" : [0,1],
    "RT" : [1,1],
    "LT" : [-1,1],
    "RB" : [1,-1],
    "LB" : [-1,-1],
}

alph = {
    "A": 1,
    "B": 2,
    "C": 3,
    "D": 4,
    "E": 5,
    "F": 6,
    "G": 7,
    "H": 8
}
n = {
    1: "A",
    2: "B",
    3: "C",
    4: "D",
    5: "E",
    6: "F",
    7: "G",
    8: "H"
}
k = list(k)
s = list(s)

sx,sy = alph[s[0]], int(s[1])
x,y = alph[k[0]],int(k[1])
# print("z",x,y)
for m in data:
    nx,ny = x + mx[m][0], y+ mx[m][1]
    if nx<=0 or nx > 8 or ny<=0 or ny> 8:
        continue
    if nx == sx and ny == sy:
        snx,sny = sx + mx[m][0], sy + mx[m][1]
        if snx <= 0 or snx > 8 or sny <= 0 or sny > 8:
            continue
        sx,sy = snx,sny

    x = nx
    y = ny
print(n[x]+str(y))
print(n[sx]+str(sy))

