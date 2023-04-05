class Solution {
    public int solution(String t, String p) {

        int answer = 0;

        int loopCount = t.length() - p.length();

        for (int i = 0 ; i <= loopCount ;  i ++) {    

            // p 자릿수만큼 부분 문자열 구하기
            String subStringT = t.substring(i, i + p.length());

            if (Long.valueOf(subStringT) <= Long.valueOf(p)) {
                answer ++;   
            }
        }

        return answer;
    }
}
