import java.util.*;

public class BOJ_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1; // 시작 인덱스
        int end = 1; // 끝 인덱스
        int sum = 1; // 합
        int count = 1; // 개수

        while (end < N) {
            if (sum < N) { // 연속 합이 N보다 작은 경우, end를 오른쪽으로 이동하면서 sum에 더해나간다.
                end ++;
                sum += end;
            } else if (sum == N) { // 연속 합이 N과 같을 경우, count를 추가하고 start와 end를 한칸씩 이동한다.
                start ++;
                end = start;
                sum = start;
                count ++;
            } else { // 연속 합이 N보다 클 경우, start와 end를 한칸씩 이동한다.
                start ++;
                end = start;
                sum = start;
            }
        }

        System.out.println(count);
    }
}
