import java.util.*;

public class BOJ_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int sum = 0;
        int max = 0;
        
        // 점수 합과 최댓값 구하기
        for (int i = 0 ; i < count ; i ++) {
            int num = sc.nextInt();

            if (num > max) {
                max = num;
            }
            sum += num;
        }

        System.out.println(sum * 100.0 / max / count);
    }
}