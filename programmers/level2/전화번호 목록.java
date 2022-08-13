import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        /*
            1. 길이 순으로 정렬
            2. 가장 짧은 길이의 번호를 기준으로 각 문자열의 substring을 비교
            3. 루프를 한번 돌고, 다음 인덱스로 넘어가서 반복
        */
        
        // 문자열 배열 정렬
        Arrays.sort(phone_book);
        
        // System.out.println(Arrays.toString(phone_book));
        
        // 가장 짧은 길이의 번호를 기준으로 각 문자열의 substring을 비교
        for (int i = 0 ; i < phone_book.length-1 ; i ++) {
            
            // 현재 인덱스에 있는 문자열 저장
            String s = phone_book[i];
            
            if (phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        
        return true;
        
    }
}