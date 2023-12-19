import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22864 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 1시간 업무 시 쌓이는 피로도
        int B = Integer.parseInt(st.nextToken()); // 업무 처리량
        int C = Integer.parseInt(st.nextToken()); // 1시간 휴식 시 줄어드는 피로도
        int M = Integer.parseInt(st.nextToken()); // 최대 피로도
        int hour = 0; // 현재 누적 시간
        int fatigue = 0; // 현재 누적 피로도
        int work = 0; // 현재 업무량

        // 24시간 동안
        while (hour < 24) {
            if (fatigue + A > M) { // 번 아웃되기 전에 휴식
                fatigue = (fatigue-C > 0) ? fatigue-C : 0; // 음수면 0으로 치환
                hour ++;
            } else { // 업무 처리
                fatigue += A;
                work += B;
                hour ++;
            }
        }
        System.out.println(work);
    }
}
