class Solution {
    public String solution(String new_id) {
        String result = new_id;
        result = convertToLowerString(new_id); // 1단계 : 전부 소문자화
        result = removeUnvalidString(result); // 2단계 : 조건 충족된 문자만 넣도록
        result = replaceManyDotToOneDot(result); // 3단계 : 두 개 이상의 연속된 .은 .로 치환 - 정규표현식 사용
        result = trimDot(result); // 4단계 : .가 처음이나 끝에 위치하면 제거 - 정규표현식 사용
        result = isEmptyThenAddA(result); // 5단계 : 빈 문자열이면 a 넣음
        result = cutIfTooLong(result); // 6단계 : 16자리 이상일 시 자르기
        result = addLastString(result); // 7단계 : 2자리 이하일 시 마지막 문자를 길이가 3이 될 때 까지 넣음
        return result;
    }
    private String convertToLowerString(String id) {
        return id.toLowerCase();
    }
    private String removeUnvalidString(String id) {
        String[] tokens = id.split("");
        StringBuilder sb = new StringBuilder("");
        for (String token : tokens) {
            if ("abcdefghijklmnopqrstuvwxyz-1234567890_.".contains(token))
                sb.append(token);
        }
        return sb.toString();
    }
    private String replaceManyDotToOneDot(String id) {
        return id.replaceAll("\\.{2,}", ".");
    }
    private String trimDot(String id) {
        return id.replaceAll("^\\.|\\.$", "");
    }
    private String isEmptyThenAddA(String id) {
        if (id.isEmpty())
            return "a";
        return id;
    }
    private String cutIfTooLong(String id) {
        if (id.length() >= 16) {
            String[] token = id.split("");
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 15; i++) {
                if (i == 14 && token[i].equals(".")) // 마지막 문자가 .면 안 넣음
                    continue;
                sb.append(token[i]);
            }
            return sb.toString();
        }
        return id;
    }
    private String addLastString(String id) {
        if (id.length() <= 2) {
            StringBuilder sb = new StringBuilder("");
            sb.append(id);
            String last = id.split("")[id.length() - 1];
            while (sb.toString().length() < 3) {
                sb.append(last);
            }
            return sb.toString();
        }
        return id;
    }
}