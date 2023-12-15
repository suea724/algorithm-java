import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 카드 개수가 적은 묶음부터 합치는 게 총 비교 횟수가 가장 적다!
        // 삽입, 삭제, 정렬이 자주 발생하므로 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        // 우선 순위 큐에 저장
        for (int i = 0 ; i < n ; i ++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        // queue에 2개 이상 요소가 있을 동안, 두개씩 꺼내서 더하고 다시 큐에 저장
        while (queue.size() >= 2) {
            int sum = queue.poll() + queue.poll();
            answer += sum;
            queue.offer(sum);
        }

        System.out.println(answer);
    }
}
