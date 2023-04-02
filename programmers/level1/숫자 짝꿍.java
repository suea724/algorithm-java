import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        
        // 각 문자와 개수를 쌍으로 저장할 map
        // keyset을 정렬된 값으로 가져오기 위해 TreeMap 사용
        Map<Character, Integer> xMap = new TreeMap<>();
        Map<Character, Integer> yMap = new TreeMap<>();
        
        List<String> result = new ArrayList();
        
        // 각 문자의 개수 세기
        for (int i = 0 ; i < X.length() ; i ++) {
            xMap.put(X.charAt(i), xMap.getOrDefault(X.charAt(i), 0) + 1);
        }
        
        for (int i = 0 ; i < Y.length() ; i ++) {
            yMap.put(Y.charAt(i), yMap.getOrDefault(Y.charAt(i), 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 공통으로 포함되는 문자를 더 적은 수만큼 더함
        for (Character key : xMap.keySet()) {
            if (yMap.keySet().contains(key)) {
                int loopCount = Math.min(xMap.get(key), yMap.get(key));
                
                for (int i = 0 ; i < loopCount ; i ++) {
                    sb.append(key);
                }
            }
        }
        
        String answer = sb.reverse().toString();

        if (answer.equals("")) { // 공통 문자가 존재하지 않을 때
            return "-1";
        } else if (answer.substring(0, 1).equals("0")) { // 0으로 시작할 때
            return "0";
        } else {
            return answer;
        }
    }
}