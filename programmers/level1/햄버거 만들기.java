import java.util.*;

// StringBuilder를 사용한 풀이 !! 시간 초과
class Solution {
    public int solution(int[] ingredient) {
        
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        // int array를 StringBuilder로 변환
        for (int i = 0 ; i < ingredient.length ; i ++) {
            sb.append(ingredient[i]);
        }

        String temp = sb.toString();
        
        // 가장 처음으로 조회된 "1231" 문자열 찾아 제거
        while (temp.indexOf("1231") > -1) {
            temp = temp.substring(0, temp.indexOf("1231")) + temp.substring(temp.indexOf("1231") + 4);
            answer ++;
        }
        
        return answer;
    }
}

// 스택 활용 풀이
class Solution {
    public int solution(int[] ingredient) {
        
        // 생성된 햄버거 개수
        int countBurger = 0;
        
        Stack<Integer> stack = new Stack();

        for (int i = 0 ; i < ingredient.length ; i ++) {
            stack.push(ingredient[i]);

            // [1,2,3,1] 순서대로 저장되어 있을 때 stack에서 꺼낸 후 햄버거 수 ++
            if (stack.peek() == 1 
                    && stack.size() > 3 
                    && stack.get(stack.size() - 2) == 3 
                    && stack.get(stack.size() - 3) == 2 
                    && stack.get(stack.size() - 4) == 1) {
                for (int j = 0 ; j < 4; j ++) {
                    stack.pop();
                }
                countBurger ++;
            }
        }
        return countBurger;
    }
}