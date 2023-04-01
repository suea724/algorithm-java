class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {        

        // 각 카드 뭉치의 index 값
        int cardIndex1 = 0;
        int cardIndex2 = 0;

        for (int i = 0 ; i < goal.length ; i ++) {

            if (cardIndex1 < cards1.length && goal[i].equals(cards1[cardIndex1])) { // 첫번째 카드 뭉치에 포함되어 있는 경우
                cardIndex1 ++;
            } else if (cardIndex2 < cards2.length && goal[i].equals(cards2[cardIndex2])) { // 두번째 카드 뭉치에 포함되어 있는 경우
                cardIndex2 ++;
            } else { // 순서가 올바르지 않은 경우 "No" 리턴
                return "No";
            }
        }

        // 반복문 종료 시 "Yes" 리턴
        return "Yes";
    }
}