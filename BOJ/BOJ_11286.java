import java.util.*;

public class BOJ_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.valueOf(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        // 우선순위 큐 선언. 정렬 기준 1. 크기 순 2. 절댓값 순
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0 ; i < size ; i ++) {
            int x = sc.nextInt();
            if (x != 0) { // 0이 아닐 때 우선순위 큐에 삽입
                queue.add(x);
            } else if (x == 0) { // 0일 때 우선순위 순서대로 출력
                if (queue.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(queue.poll());
                }
                if (i == size - 1) break;
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
