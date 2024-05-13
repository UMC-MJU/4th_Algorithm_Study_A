from itertools import combinations


def solution(orders, course):
    answer = []
    for c in course:
        ncount = {}
        for order in orders:
            datas = list(combinations(list(order), c))
            for data in datas:
                data = sorted(data)
                data = "".join(data)

                if data in ncount:
                    ncount[data] += 1
                else:
                    ncount[data] = 1
        if ncount != {}:
            m = max(ncount.values())
            if m >= 2:
                pass
                for k, v in ncount.items():
                    if v == m:
                        answer.append(k)
        answer.sort()
    return answer