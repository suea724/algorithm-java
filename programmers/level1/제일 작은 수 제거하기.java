import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // 배열 길이가 1보다 작을 때 바로 리턴
        if (arr.length <= 1) {
            int[] answer = {-1};
            return answer;
        }
        
        // 최소값 구하기
        int min = arr[0];
        
        for (int i = 0 ; i < arr.length ; i ++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        // 최솟값 제외, ArrayList에 넣기
        for (int i = 0 ; i < arr.length ; i ++) {
            if (arr[i] == min) {
                continue;
            }
            list.add(arr[i]);
        }
        
        // ArrayList -> Array
        return list.stream().mapToInt(n->n).toArray();
    }
}