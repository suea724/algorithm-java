class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int dsum = 0;
        
        String[] digits = (Integer.toString(x)).split("");
        
        for(String digit : digits) {
            dsum += Integer.parseInt(digit);
        }
        
        answer = (x % dsum == 0);
        
        return answer;
    }
}