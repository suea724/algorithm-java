import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        StringTokenizer st;

        // 회의 시간 입력받기
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken()); // 시작 시간
            int endTime = Integer.parseInt(st.nextToken()); // 종료 시간
            time[i][0] = startTime;
            time[i][1] = endTime;
        }
        
        // 종료 시간 기준 정렬 후, 시작 시간 기준 정렬 > 선택 시 종료 시간이 기준이 되므로!
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o2[1] != 0) ? o1[1] - o2[1] : (o1[0] - o2[0]);
            }
        });

        int count = 0; // 회의 수
        int prevEndTime = 0; // 이전 회의 종료 시간

        for (int i = 0 ; i < time.length ; i ++) {
            // 현재 회의 시작 시간이 이전 회의 종료 시간보다 늦으면 선택
            if (prevEndTime <= time[i][0]) {
                prevEndTime = time[i][1]; // 이전 회의 종료 시간 갱신
                count ++;
            }
        }

        System.out.println(count);
    }
}
