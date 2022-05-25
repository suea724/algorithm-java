class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true; // 대문자 변경 필요 여부
        
        for (int i = 0 ; i < s.length() ; i ++) {
            
            // toUpperCase, toLowerCase 사용하기 위해 charAt 대신 substring 사용
            String temp = s.substring(i,i+1); 
            
            if (temp.equals(" ")) {
                answer += temp;
                flag = true; // 공백 뒤에 오는 알파벳은 대문자 변경 필요
                continue;
            }

            if (flag) { // 단어 기준 홀수번째
                answer += temp.toUpperCase();
                flag = false;
            } else { // 단어 기준 짝수번째
                answer += temp.toLowerCase();
                flag = true;
            }
        }
    
        return answer;
    }
}