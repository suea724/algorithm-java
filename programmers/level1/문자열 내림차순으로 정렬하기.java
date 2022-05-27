import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] temp = s.split("");
        
        Arrays.sort(temp); // 오름차순 정렬
        
        for (int i = temp.length-1 ; i >= 0 ; i --) { // 역순으로 answer에 입력
            answer += temp[i];
        }
        
        return answer;
    }
    
}