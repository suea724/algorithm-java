import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder(); // 출력할 문자열
        
        // 테스트 케이스만큼 반복
        for (int i = 0 ; i < T ; i ++) {
            // 일 수
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stack = new int[N]; // 일별 주식 가격 배열
            long profit = 0; // 누적 이익 (int 범위를 넘어설 수 있으므로 long 타입으로 선언)
            int max = 0; // 최댓값

            // 배열에 담아두기
            for (int j = 0 ; j < N ; j ++) {
                stack[j] = Integer.parseInt(st.nextToken());
            }

            // 배열 역순으로 탐색
            for (int j = stack.length-1 ; j >= 0 ; j --) {

                // 현재 값이 max보다 작으면 이익에 누적
                if (stack[j] < max) {
                    profit += max - stack[j];
                } else { // 저장되어 있는 max값보다 큰 값이 나왔을 때 max 값 업데이트
                    max = stack[j];
                }
            }

            sb.append(profit + "\n");
        }

        System.out.println(sb.toString());
    }
}
