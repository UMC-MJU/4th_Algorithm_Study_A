# 개인정보 수집 유효기간 https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=python3

from typing import Dict


def solution(today, terms, privacies):
    answer = []

    term2month = create_term2month(terms)
    today_num = date2num(today)

    for index, privacy in enumerate(privacies):
        date, term = privacy.split()
        month = term2month[term]
        # 개인정보 수집 일자와 약관 유효기간을 더해서 파기 날짜를 구한다.
        expire_num = add_date_month(date, month)

        if expire_num <= today_num:
            answer.append(index + 1)

    return answer


# 약관 종류와 유효기간 매핑
def create_term2month(terms) -> Dict[str, int]:
    term2month = {}
    for i in terms:
        term, month = i.split()
        term2month[term] = int(month)
    return term2month


# 날짜(string)를 계산하기 편하도록 int로 변환
def date2num(date) -> int:
    year, month, day = date.split(".")
    year = int(year)
    month = int(month)
    day = int(day)
    return (year * 12 + month) * 28 + day


# 개인정보 수집 일자에 유효기간 더하기
def add_date_month(date, month) -> int:
    return date2num(date) + month * 28