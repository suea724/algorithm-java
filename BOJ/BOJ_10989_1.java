import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 시간 초과.
// 기수 정렬. 시간 복잡도 : O(kN)
public class BOJ_10989_1 {

    static final int BUCKET_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        
        int maxDigit = 0;

        // 배열 저장
        for (int i = 0 ; i < n ; i ++) {
            String input = br.readLine();
            arr[i] = Integer.valueOf(input);

            // 최대 자릿수 저장
            if (maxDigit < input.length()) 
                maxDigit = input.length();
        }

        radixSort(arr, maxDigit);

        for (int i = 0 ; i < arr.length ; i ++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr, int maxDigit) {
        int[] sorted = new int[arr.length];

        // 최대 자릿수까지 반복
        for (int i = 0 ; i < maxDigit ; i ++) {
            int[] bucketSumArr = new int[BUCKET_SIZE];

            for (int j = 0 ; j < arr.length ; j ++) {
                int digitNum = (int) (arr[j] / Math.pow(10, i) % 10);
                bucketSumArr[digitNum] ++;
            }

            // 인덱스를 찾기 위한 합배열 구하기
            for (int j = 1 ; j < bucketSumArr.length ; j ++) {
                bucketSumArr[j] += bucketSumArr[j-1];
            }
            
            // 정렬된 배열 구하기 > 거꾸로 찾아가면서 채워넣기
            for (int j = arr.length-1 ; j >= 0 ; j --) {
                int digitNum = (int) (arr[j] / Math.pow(10, i) % 10);
                int index = bucketSumArr[digitNum]-1;
                sorted[index] = arr[j];
                bucketSumArr[digitNum]--;
            }

            // 원래 배열을 정렬된 배열로 변경
            for (int j = 0 ; j < arr.length ; j ++) {
                arr[j] = sorted[j];
            }
        }
    }
}
