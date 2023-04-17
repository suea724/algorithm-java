import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;
        int max = people.length-1;
        
        // 오름차순 정렬
        Arrays.sort(people);                                                                                        

        while (min <= max) {
            // (가장 가벼운 사람 무게 + 가장 무거운 사람 무게)가 제한 무게 이하이면 두 사람을 태울 수 있음, 인덱스 각각 한칸씩 앞으로 이동
            if (people[min] + people[max] <= limit) {
                answer ++;
                min ++;
                max --;
            } else { // 제한 무게 초과이면 무거운 사람 한명만 태울 수 있음, max만 한칸 앞으로 이동
                answer ++;
                max --;
            }
        }

        return answer;
    }
}