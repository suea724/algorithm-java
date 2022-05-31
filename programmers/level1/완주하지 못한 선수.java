import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
		
		/* 배열로 풀기 > 시간복잡도 O(nlogn) + O(nlogn) + O(n) = O(nlogn) */
        
		// 오름차 순으로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
		// 완주 선수 수만큼 반복
        for (int i = 0 ; i < completion.length ; i ++) {
            if (!participant[i].equals(completion[i])) { // 참가자와 완주자가 불일치 시, 참가자 리턴
                return participant[i];
            }
        }
        
        return participant[participant.length-1]; // for문 빠져나오면 마지막 참가자 리턴
		
		/* HashMap으로 풀기 > 시간복잡도 O(n) */
		String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1); // player에 value가 있으면 +1, 없으면 1
        }
        
        for (String player : completion) {
            map.put(player, map.get(player)-1); // 완주 시 player의 value-1
        }
        
        for (String player : map.keySet()) {
            if (map.get(player) != 0) { // 완주하지 않은 player 리턴
                answer = player;
            }
        }
        
        return answer;
    }
	
}