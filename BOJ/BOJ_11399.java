import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = 1 ; i < n ; i ++) {
            int insertIndex = -1;

            // 삽입 위치 찾기
            for (int j = 0 ; j < i ; j ++) {
                // j번째 수가 i번째 수보다 커지는 순간
                if (arr[j] > arr[i]) {
                    insertIndex = j;
                    break;        
                }
            }

            //  중간에 값을 넣을 경우 shift
            if (insertIndex > -1) {
                int insertValue = arr[i];
                for (int j = i ; j > insertIndex ; j --) {
                    arr[j] = arr[j-1];
                }

                arr[insertIndex] = insertValue;
            }
        }

        // 합 배열의 총 합 구하기
        for (int i = 0 ; i < arr.length ; i ++) {
            sum += arr[i];
            answer += sum;
        }

        System.out.println(answer);
    }
}
