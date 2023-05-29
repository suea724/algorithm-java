import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];

        // 배열에 저장
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        // 정렬
        for (int i = 0 ; i < arr.length ; i ++) {
            for (int j = i+1 ; j < arr.length ; j ++) {
                if (arr[i] > arr[j]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(arr[i]);
        }
    }
}
