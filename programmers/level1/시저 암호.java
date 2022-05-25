class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            
            if (c >= 65 && c <= 90) { // 대문자일 경우
                answer += (char)(c + n > 90 ? (c + n) % 90 + 64 : c + n);
                continue;
            }
            
            if (c >= 97 && c <= 122) { // 소문자일 경우
                answer += (char)(c + n > 122 ? (c + n) % 122 + 96 : c + n);
                continue;
            }
            
			answer += c;    
            
        }
        
        return answer;
    }
}