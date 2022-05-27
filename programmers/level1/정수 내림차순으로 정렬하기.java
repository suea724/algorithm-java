import java.util.Arrays;

class Solution {
    public long solution(long n) {
		
		// String의 split 메서드로 각 자릿수를 저장한 배열을 생성하고, 이를 정렬하여 역순으로 별도의 String 변수에 입력한 후 Long 타입으로 형변환
        long answer = 0;
        String snum = "";
        
        String[] temp = Long.toString(n).split("");
        Arrays.sort(temp);
        
        for (int i = temp.length - 1 ; i >= 0 ; i --) {
            snum += temp[i];
        }
        
        answer = Long.parseLong(snum);
        return answer;
    }
}