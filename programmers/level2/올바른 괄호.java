import java.util.*;

class Solution {
    boolean solution(String s) {

        // split으로 String 배열 사용 시 효율성 0점 > charAt() 사용

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0 ; i < s.length() ; i ++) {
            
            if (s.charAt(i) == '(') { // 여는 괄호일 경우 stack에 push
                stack.push(s.charAt(i));
            } else { // 닫는 괄호일 경우 pop
                
                if (stack.isEmpty()) { // stack에 열린 괄호가 없으면 바로 false 반환
                    return false;
                }
                
                stack.pop();    
                
            }
        }

        return stack.isEmpty();
    }
}