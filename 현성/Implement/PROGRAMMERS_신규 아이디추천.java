class Main{
    public String solution(String new_id) {
        //1단계  대문자를 소문자로 변환하기
        new_id = new_id.toLowerCase();

        //2단계 특수기호 제거하기
        //[1번째 시도]정규식을 알긴했지만 쓸 생각을 못했음 , replaceAll()를 사용하면 된다는것을 알게됨
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        //첫번째 파라미터가 온다면 두번째 파라미터로 변경해주는 메서드 ->replaceAll()

        //3단계 2번이상 연속된 .을 한번의 .으로 바꾸기
        new_id = new_id.replaceAll("[.]+" , ".");

        //4단계 .이 처음이나 끝에 위치한다면 제거하기
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        //^는 처음 , $은 끝을 의미하고 |이것으로 OR을 하여  .이  나온다면 두번째 파라미터로 대체합니다.

        //5단계 if 빈 문자열이라면 a대입하기
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        //6단계 15자 문자까지만 출력하기
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        //7단계 if 문자열 길이가 2자이하라면 마지막 문자를 길이가 3이 될때까지 반복하기
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        //인덱스가 0부터 시작하니 1을 빼주어야 마지막 인덱스 문자가 출력될수 있다.

        return new_id;
    }

}