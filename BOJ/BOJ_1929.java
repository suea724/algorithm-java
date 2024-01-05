import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[max+1];
        // 0, 1 값 초기화
        arr[0] = true;
        arr[1] = true;

        for (int i = 2 ; i < arr.length ; i ++) {
            // true이면 skip
            if (arr[i] == true) continue;

            // 현재 값의 배수 값을 true로 설정
            for (int j = i*2 ; j < arr.length ; j += i) {
                arr[j] = true;
            }
        }

        // min ~ max 구간에서 소수 출력
        for (int i = min ; i <= max ; i ++) {
            if (arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}
