import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
		// 사전 순으로 정렬
        Arrays.sort(strings, (o1, o2) -> o1.compareTo(o2));
		
		// n번째 문자 기준으로 정렬
        Arrays.sort(strings, (o1, o2) -> o1.substring(n, n+1).compareTo(o2.substring(n, n+1)));

        return strings;
    }
}