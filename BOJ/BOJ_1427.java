import java.util.Scanner;

public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] arr = new int[input.length()];

        for (int i = 0 ; i < arr.length ; i ++) {
            arr[i] = input.charAt(i) - '0';
        }

        // 선택 정렬
        for (int i = 0 ; i < arr.length ; i ++) {
            int maxValue = arr[i]; // 가장 큰 수 
            int maxIndex = i; // 가장 큰 수의 위치
            for (int  j = i+1 ; j < arr.length ; j ++) {
                // i번째 수보다 클 경우, 값 및 인덱스 저장
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            // i번째 값과 maxIndex번째의 값을 swap
            arr[maxIndex] = arr[i];
            arr[i] = maxValue;

            System.out.print(arr[i]);
        }
    }
}
