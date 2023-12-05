import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

    static int[] criteriaArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        criteriaArr = new int[n];  // 기준 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            criteriaArr[i] = Integer.parseInt(st.nextToken());
        }

        // 기준 배열 오름차순 정렬
        Arrays.sort(criteriaArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 입력값 순서대로 이진 탐색 수행
        for (int i = 0 ; i < m ; i ++) {
            int inputNum = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(inputNum, 0, m-1));
        }
    }

    // 이진 탐색 - 재귀 호출
    private static int binarySearch(int targetNum, int low, int high) {
        if (high < low) return 0; // 요소가 존재하지 않으면 종료
        int mid = (low + high) / 2; // 중간 인덱스

        if (criteriaArr[mid] > targetNum) { // 중간에 위치한 수가 찾으려는 수보다 크면, 배열 앞 반쪽으로 탐색 계속
            return binarySearch(targetNum, low, mid-1);
        } else if (criteriaArr[mid] < targetNum) { // 중간에 위치한 수가 찾으려는 수보다 작으면, 배열 뒤 반쪽으로 탐색 계속
            return binarySearch(targetNum, mid+1, high);
        } else { // 중간에 위치한 수가 찾으려는 수와 같으면 중간 인덱스 반환
            return 1;
        }
    }
}
