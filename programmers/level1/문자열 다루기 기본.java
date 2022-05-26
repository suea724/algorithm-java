class Solution {
    public boolean solution(String s) {
        
        if (s.length() != 4 && s.length() != 6) { // 문자열 길이 4 또는 6인지 체크
            return false;
        }
        
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') { // 숫자로 구성되어 있는지 체크
                return false;
            }
        }
     return true; // for문 빠져나오면 true 리턴
    }
}