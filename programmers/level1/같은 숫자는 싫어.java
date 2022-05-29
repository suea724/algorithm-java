import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // 중복 숫자 개수를 알 수 없으므로 가변 배열인 ArrayList 사용
        ArrayList<Integer> list = new ArrayList<>();
        
        // 앞 값과 뒤 값이 다른 경우 앞 값을 list에 입력
        for (int i = 0 ; i < arr.length-1 ; i ++) {
            if (arr[i] != arr[i+1]) {
                list.add(arr[i]);
            }
        }
        
        // 마지막 값 입력
        list.add(arr[arr.length-1]);

        return list.stream().mapToInt(n->n).toArray();
    }
}