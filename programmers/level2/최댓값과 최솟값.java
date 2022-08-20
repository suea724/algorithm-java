import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 공백을 기준으로 split
        String[] temp = s.split(" ");
        
        // 정수로 변환한 값을 기준으로 오름차순 정렬
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.parseInt(a) - Integer.parseInt(b);
            }
        });
        
        // 최솟값과 최댓값을 이용해 문자열 만들기
        answer += temp[0] + " " + temp[temp.length-1];
        
        return answer;
    }
}