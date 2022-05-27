import java.util.*;

class Solution {
    public int[] solution(long n) {
        String[] temp = Long.toString(n).split(""); // 자릿수 저장할 String 배열
        int[] answer = new int[temp.length];

        for (int i = 0 ; i < temp.length ; i ++) { 
            answer[temp.length-i-1] = Integer.parseInt(temp[i]); // 각 요소 int로 형변환 후 temp와 역순으로 값 저장
        }
        return answer;
    }
}