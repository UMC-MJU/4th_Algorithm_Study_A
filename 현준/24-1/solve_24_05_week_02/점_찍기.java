class 점_찍기 {

    // 24.05.10 (금)
    // 수학적 접근이 필요했음 (피타고라스 정리는 떠올렸으나, 원의 방정식을 생각해내지 못함)

    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i+=k) {
            int x = i;
            int yMax = yMax(x, d); // x가 주어질 때 y의 최대 지점을 구할 수 있음
            answer += count(yMax, k); // 0 ~ y의 최대 지점 중 k의 배수 + 0 위치를 계산 후 더함
        }
        return answer;
    }

    // 피타고라스 정리를 이용하면 x^2 + y^2 = d^2, 원의 방정식을 활용하면 x^2 + y^2 <= d^2가 되어야 하고
    // x를 넘기면 d^2 - y^2에서 착안한다.
    // ak, d의 최대 범위가 백만까지 되므로 범위를 고려하여 long으로 캐스팅
    private int yMax(int x, int d) {
        long xx = (long) Math.pow(x, 2);
        long dd = (long) Math.pow(d, 2);

        return (int) Math.sqrt(dd - xx);
    }

    // 점이 찍혀진 곳끼리만 이어질 수 있다.
    // y의 최대 지점을 k로 나누면 k의 배수의 갯수를 구할 수 있다.
    // 그런데 y가 0일 때도 고려해야 하므로 1을 더한다.
    private int count(int max, int k) {
        return (max / k) + 1;
    }
}
