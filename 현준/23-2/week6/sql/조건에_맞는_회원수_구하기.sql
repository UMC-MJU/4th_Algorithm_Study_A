-- 코드를 입력하세요
SELECT COUNT(USER_ID) AS USERS FROM USER_INFO WHERE AGE >= 20 AND AGE <= 29 AND JOINED LIKE '2021%';
-- COUNT(column): 특정 column 갯수 파악 (중복 처리 X - 원한다면 DISTINCT 앞에 붙임)
-- WHERE AND: AND 연산으로 조건 걸기
-- column LIKE 'A%': column 내용이 A로 시작되는 것 조회, %A는 A로 끝나는 것, %A%는 가운데에 A가 들어있는 것
