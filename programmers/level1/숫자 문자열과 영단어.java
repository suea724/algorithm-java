class Solution {
    public int solution(String s) {
        
        String answer = "";
        String temp = ""; // 영문자일 경우, 값이 숫자 범위인지 판별하기 위한 변수
        
        for (int i = 0 ; i < s.length() ; i ++) {
            
            char c = s.charAt(i);
            
            if (c >= 'a' && c <= 'z') { // 영문자일 때
                temp += String.valueOf(c);
            } else { // 숫자일 때
                answer += String.valueOf(c);
            }
            
            if (wordToNum(temp) != -1)  { // 영문자가 숫자로 바꿀 수 있는 경우
                answer += wordToNum(temp); // 단어를 숫자로 바꾸어 저장
                temp = ""; // temp 초기화
            }
        }
        
        return Integer.parseInt(answer);
    }
    
    public int wordToNum(String num) { // 영어 단어를 숫자로 변환해주는 함수, 변환 불가능한 문자열이 들어오면 -1을 반환
        switch(num) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return -1;
                
        }
    }
}