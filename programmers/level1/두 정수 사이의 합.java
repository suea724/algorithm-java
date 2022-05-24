class Solution {
    public long solution(int a, int b) {
        long answer = a;
        int sign = 0;
        
        sign = a < b ? 1 : -1;
        
        while (a != b) {
            a = a + sign;
            answer += a;
        }
        
        return answer;
    }
}