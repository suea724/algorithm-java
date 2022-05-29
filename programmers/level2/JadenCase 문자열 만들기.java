class Solution {
    public String solution(String s) {
        // 첫 문자 대문자로 변환해서 입력
        String answer = s.substring(0, 1).toUpperCase();
        
        for (int i = 1 ; i < s.length() ; i ++) {
            String temp = s.substring(i, i+1);
            
            if (s.charAt(i) == ' ') { // 공백일 경우 별도 처리 없이 입력
                answer += temp;
            } else if (s.charAt(i-1) == ' ') { // 이전 문자가 공백일 경우 대문자 변환해서 입력
                answer += temp.toUpperCase();
            } else {
                answer += temp.toLowerCase();
            }
        }
        
        return answer;
    }
}