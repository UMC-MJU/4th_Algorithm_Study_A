def solution(n, left, right):
    rst = []
    for i in range(left, right + 1):
        m = i // n
        s = i % n

        rst.append(max(m, s) + 1)
    return rst