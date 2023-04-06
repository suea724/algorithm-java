import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(score);
        
        // 뒤에서부터 m씩 잘랐을 때, 각 상자의 이익 = (첫번째 값 * 한 상자당 사과 수)
        for (int i = score.length - m ; i >= 0 ; i -= m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}