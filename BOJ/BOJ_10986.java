import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()); // 수 개수
        int m = Integer.valueOf(st.nextToken()); // 나누는 수
        long[] remainderArr = new long[m]; // 합 배열의 나머지 개수를 저장할 배열
        long sum = 0; // 합을 구하기 위한 변수
        long answer = 0;
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            int num = Integer.valueOf(st.nextToken());
            sum += num;
            int remainder = (int) (sum % m); // 0 ~ i까지 수의 나머지

            if (remainder == 0) answer ++;

            remainderArr[remainder] ++;
        }

        // 나머지가 같은 인덱스 두개를 뽑을 경우 그 구간 합의 나머지는 0
        for (int i = 0 ; i < remainderArr.length ; i ++) {
            answer += remainderArr[i] * (remainderArr[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
