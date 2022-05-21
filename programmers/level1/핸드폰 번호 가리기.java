class Solution {
    public String solution(String phone_number) {
        
        String answer = "";
        String front = "";
        String back = "";
        
        for(int i = 0 ; i < phone_number.length() - 4 ; i ++) {
            front += "*";
        }
        
        back = phone_number.substring(phone_number.length() - 4);
        answer = front + back;        

        return answer;
    }
}