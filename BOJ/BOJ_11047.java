import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int targetSum = Integer.parseInt(st.nextToken());
        int[] coinList = new int[coinCount];
        int answer = 0;

        // 동전 종류 저장
        for (int i = 0 ; i < coinCount ; i ++) {
            coinList[i] = Integer.parseInt(br.readLine());
        }

        // 동전 가치가 큰 순으로 나누기.
        // 몫은 동전 개수에 추가, 나머지는 다음 피연산자로 저장
        // 더이상 나눌 수 없으면(= 0이면) 반복문 탈출
        for (int i = coinList.length-1 ; i >= 0 ; i --) {
            if (coinList[i] <= targetSum) {
                answer += targetSum / coinList[i];
                targetSum = targetSum % coinList[i];
            }

            if (targetSum == 0) break;
        }

        System.out.println(answer);
    }
}