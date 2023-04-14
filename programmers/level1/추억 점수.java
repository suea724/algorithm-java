import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        // map에 "이름" : "점수" 입력
        for (int i = 0 ; i < name.length ; i ++) {
            map.put(name[i], yearning[i]);
        }

        // 문자열에 해당하는 점수가 있으면 더하고, 없으면 0을 더함
        for (int i = 0 ; i < photo.length ; i ++) {
            int score = 0;
            for (int j = 0 ; j < photo[i].length ; j ++) {
                score += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = score;
        }

        return answer;
    }
}