import java.util.*;

class Solution {
    boolean solution(String s) {

        String[] temp = s.split("");
        Stack<String> stack = new Stack<>();
        
        // 닫는 괄호로 시작하거나 여는 괄호로 끝나면 false 반환
        if (temp[0].equals(")") || temp[temp.length-1].equals("(")) {
            return false;
        }
        
        for (int i = 0 ; i < temp.length ; i ++) {
            if (temp[i].equals("(")) { // 여는 괄호일 경우 stack에 push
                stack.push(temp[i]);
            } else { // 닫는 괄호일 경우 pop
                
                if (stack.isEmpty()) {
                    return false;
                }
                
                stack.pop();    
                
            }
        }

        return stack.isEmpty();
    }
}