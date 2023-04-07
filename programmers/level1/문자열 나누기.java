import java.util.*;
/**
 * 굳이 Stack 사용하지 않아도 댐
 */
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        
        // 첫번째 글자 스택에 저장
        stack.push(s.charAt(0));
        
        for (int i = 1 ; i < s.length() ; i ++) {
            // 스택에 값이 없거나, 이전 문자와 값이 같으면 push
            if (stack.size() == 0 || stack.peek() == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else { // 다를 경우  pop
                stack.pop();
                
                if (stack.size() == 0) { // 문자열 완성 시
                    answer ++;
                }
            }
        }
        
        // 스택에 값이 남아있는 경우
        if (stack.size() > 0) {
            answer ++;
        }
        
        return answer;
    }
}