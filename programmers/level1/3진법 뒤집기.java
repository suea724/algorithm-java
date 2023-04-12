import java.lang.Math;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        
        // 3진법 구하기
        while (n / 3 > 0) {
            s = n % 3 + s;
            n = n / 3;
        }
        
        if (n < 3) {
            s = n + s;
        }
        
        // 10진법 변환
        for (int i = 0 ; i < s.length() ; i ++) {
            if (s.charAt(i) == '0') {
                continue;
            } else if (s.charAt(i) == '1') {
                answer += Math.pow(3, i);
            } else if (s.charAt(i) == '2') {
                answer += Math.pow(3, i) * 2;
            }
        }
       
        return answer;
    }
}