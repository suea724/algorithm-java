import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 입력
        for (int i = 1 ; i <= n ; i ++) {
            queue.add(i);
        }

        // queue에 2개 이상의 수가 남아있을 때
        while (queue.size() > 1) {
            // 가장 위에 있는 수 버리기
            queue.poll();

            // 가장 위에 있는 수 아래에 넣기
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
