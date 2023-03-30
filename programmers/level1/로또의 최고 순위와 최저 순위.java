import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];
        
        List<Integer> winNumList = Arrays.stream(win_nums)
                                            .boxed()
                                            .collect(Collectors.toList());
        
        int winCount = 0; // 당첨된 개수
        int zeroCount = 0; // 0 개수

        for (int i = 0 ; i < lottos.length ; i ++) {
            if (lottos[i] == 0) {
                zeroCount ++;
            } else if (winNumList.contains(lottos[i])) {
                winCount ++;
            }
        }

        answer[0] = getRank(winCount + zeroCount); // 최대 등수
        answer[1] = getRank(winCount); // 최소 등수

        return answer;
    }

    // 당첨 번호 개수로 등수 조회
    public int getRank(int winCount) {
        switch(winCount) {
            case 6 :
               return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }

}