import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;

        // '-' 기준으로 split
        String[] subtraction = input.split("\\-");

        for (int i = 0 ; i < subtraction.length ; i ++) {
            // '+' 기준으로 split
            String[] addition = subtraction[i].split("\\+");

            int temp = 0;
            
            for (int j = 0 ; j < addition.length ; j ++) {
                temp += Integer.parseInt(addition[j]);
            }
            
            if (i == 0) { // 첫번째 값이면 더하기
                answer += temp;
            } else { // 나머지 값이면 빼기
                answer -= temp;
            }
        }

        System.out.println(answer);
    }
}
