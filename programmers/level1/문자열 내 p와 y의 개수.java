class Solution {
    boolean solution(String s) {
        
        int count = 0;
        
        String temp = s.toLowerCase();
        
        for (int i = 0 ; i < temp.length() ; i ++) {
            if (temp.charAt(i) == 'p') {
                count ++;
            }
            
            if (temp.charAt(i) == 'y') {
                count --;
            }
        }
    
        return count == 0;
    }
}