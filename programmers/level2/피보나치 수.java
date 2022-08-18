import java.util.*;

class Solution {
    public int solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // 초기값, index = 0일 때 0, index = 1일 때 1
        list.add(0);
        list.add(1);
        
        // (A + B) % 1234567 == (A % 1234567 + B % 1234567) % 1234567
        // 오버플로우 방지를 위해 다음과 같은 식으로 더해나간다.
        for (int i = 2 ; i <= n ; i ++) {
            list.add((list.get(i-1) % 1234567 + list.get(i-2) % 1234567) % 1234567);
        }
        
        // n번째 수 반환
        return list.get(n);
    }

}