import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(); // 음수 오름차순 정렬
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>((a, b) -> b - a); // 양수 내림차순 정렬
        int answer = 0;

        // 우선순위 큐에 입력받은 값을 음수, 양수 구분해서 각 큐에 넣어두기
        for (int i = 0 ; i < n ; i ++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                positiveQueue.offer(input);
            } else {
                negativeQueue.offer(input);
            }
        }

        // 음수 또는 0일 경우
        while (!negativeQueue.isEmpty()) {
            int currentVal = negativeQueue.poll();

            if (negativeQueue.size() > 0) { // 현재값 * 다음값 
                answer += currentVal * negativeQueue.poll();
            } else { // 0이거나 음수 하나 남았을 때
                answer += currentVal;
            }
        }

        // 양수일 경우
        while (!positiveQueue.isEmpty()) {
            int currentVal = positiveQueue.poll();

            if (positiveQueue.size() > 0) {
                int nextVal = positiveQueue.poll();

                if (nextVal != 1) { // 현재값 * 다음값
                    answer += currentVal * nextVal;
                } else { // 1은 곱하는 것보다 더하는게 이득
                    answer += currentVal + nextVal;
                }
            } else {
                answer += currentVal;
            }
        }

        System.out.println(answer);
    }
}