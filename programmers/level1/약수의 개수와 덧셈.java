class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        // left부터 right까지
        for (int i = left ; i <= right; i ++) {
            
            int cnt = 0;
            
            // 각 수의 약수 개수 구하기
            for (int j = 1 ; j <= i ; j ++) {
                if (i % j == 0) {
                    cnt ++;
                }
            }
            
            // 약수 짝수, 홀수에 따라 다르게 연산
            if (cnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}