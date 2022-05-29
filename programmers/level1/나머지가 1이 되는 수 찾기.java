class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1부터 차례대로 나누었을때 나머지가 1이면 바로 반환
        for (int i = 1 ; i < n ; i ++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}