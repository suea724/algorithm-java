import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
		
		// 더해서 만들 수 있는 수를 저장할 가변형 배열
        ArrayList<Integer> list = new ArrayList<>();
        
		// 서로 다른 인덱스에 있는 두 수 차례로 더해서 list에 입력
        for (int i = 0 ; i < numbers.length-1 ; i ++) {
            for (int j = i+1 ; j < numbers.length ; j ++) {
                 list.add(numbers[i] + numbers[j]);
            }
        }
        
		// 오름차순 정렬
        Collections.sort(list);
        
		// 중복값 제거
        for (int i = 1 ; i < list.size() ; i ++) {
            if (list.get(i).equals(list.get(i-1))) { // list의 요소 타입은 Integer므로 비교할 때 equals 사용!
                list.remove(i);
                i--;
            }
        }
               
        return list.stream().mapToInt(n->n).toArray();
    }

}