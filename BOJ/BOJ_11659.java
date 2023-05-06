import java.util.*;

public class BOJ_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCount = sc.nextInt(); // 수의 개수
        int quizCount = sc.nextInt(); // 합을 구해야 하는 횟수

        // 인덱스 예외 방지를 위해 array size 설정 및 첫번째 값 0으로 저장
        int[] arr = new int[numCount+1];
        arr[0] = 0;

        // 합 배열 구하기
        for (int i = 1 ; i < numCount+1 ; i ++) {
            arr[i] = arr[i-1] + sc.nextInt();
        }

        // 구간 합 구하기 
        for (int i = 0 ; i < quizCount ; i ++) {
            int min = sc.nextInt();
            int max = sc.nextInt();

            System.out.println(arr[max] - arr[min-1]);
        }
    }
}
