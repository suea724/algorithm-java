import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        
        // 1, 2, 3번 학생의 답 패턴
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 각자 맞은 점수를 저장할 변수
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        
        for (int i = 0 ; i < answers.length ; i ++) {
            
            // 문제와 답의 패턴이 일치할 때 점수+1
            if(answers[i] == first[i % first.length]) {
                firstScore ++;
            }
            
            if(answers[i] == second[i % second.length]) {
                secondScore ++;
            }
            
            if(answers[i] == third[i % third.length]) {
                thirdScore ++;
            }
            
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        // max를 첫번째 값으로 초기화
        int max = firstScore;
        
        // ArrayList에 초기값으로 첫번째 수포자 저장
        answer.add(1);
        
        if (max < secondScore) { // 두번째 수포자 점수가 더 크면
            answer.remove(new Integer(1));
            answer.add(2);
            max = secondScore;
        } else if (max == secondScore) { // 같으면 추가
            answer.add(2);
        }
        
        if (max < thirdScore) { // 세번째 수포자 점수가 더 크면
            answer.remove(new Integer(1));
            answer.remove(new Integer(2));
            answer.add(3);
        } else if (max == thirdScore) { // 같으면 추가
            answer.add(3);
        }
        
        return answer;
    }
}