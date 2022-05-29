import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
		
		// 배열 중 나누어떨어지는 수의 개수를 알 수 없으므로 가변 배열인 ArrayList 사용
        ArrayList<Integer> list = new ArrayList<>();
		// 나누어 떨어지는 수의 개수 저장할 변수
        int count = 0;
        
        for (int i = 0 ; i < arr.length ; i ++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
                count ++;
            }
        }
        
        if (count == 0) {
            return new int[]{-1};
        }
        return list.stream().sorted().mapToInt(n->n).toArray();
    }
}