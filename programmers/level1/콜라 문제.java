class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        // 콜라 개수가 기준 개수보다 크거나 같을 때,
        while (n >= a) {

            // 한 루프 당 받는 콜라 개수 = (콜라 개수 / 기준 개수 * 받는 병 수)
            answer += n / a * b;

            // 다음 루프 콜라 개수 = (콜라 개수 / 기준 개수 * 받는 병 수) + (콜라 개수를 기준 개수로 나누었을 때 나머지)
            n = (n / a * b) + (n % a);
        }
        
        return answer;
    }
}