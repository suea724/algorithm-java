import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2751 {

    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        sorted = new int[arr.length]; // 합치는 과정에서 정렬된 원소를 담을 임시배열

        // 배열에 저장
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        mergeSort(arr, 0, arr.length-1);
        
        for (int i = 0 ; i < arr.length ; i ++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
    
    private static void mergeSort(int[] arr, int start, int end) {

        // 재귀 종료 조건 : 부분 리스트가 1개의 원소만 가지고 있을 때 더 이상 쪼갤 수 없으므로 return
        if (start == end) return;

        int mid = (start + end) / 2; // 절반 위치

        mergeSort(arr, start, mid); // 왼쪽 부분 리스트
        mergeSort(arr, mid + 1, end); // 오른쪽 부분 리스트
        
        merge(arr, start, mid, end); // 정렬하여 병합
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int tempIdx = start; 
        int left = start; // 왼쪽 부분 리스트의 시작 인덱스
        int right = mid + 1; // 오른쪽 부분 리스트의 시작 인덱스
        
        // 왼쪽 리스트의 인덱스가 mid까지 온 경우 왼쪽 정렬 완료
        // 오른쪽 리스트의 인덱스가 end까지 온 경우 오른쪽 정렬 완료
        // 왼쪽 or 오른쪽 둘 중 하나라도 정렬이 완료된 경우 반복문을 빠져나간다.
        while (left <= mid && right <= end) {
            // 오름차순 조건
            if (arr[left] <= arr[right]) {
                sorted[tempIdx++] = arr[left++];
            } else {
                sorted[tempIdx++] = arr[right++];
            }
        }

        if (left > mid) { // 왼쪽 리스트 정렬이 끝난 경우
            while (right <= end) { // 오른쪽 리스트에 남아 있는 값을 저장한다.
                sorted[tempIdx++] = arr[right++];
            }
        } else { // 오른쪽 리스트 정렬이 끝난 경우
            while (left <= mid) { // 왼쪽 리스트에 남아있는 값을 저장한다.
                sorted[tempIdx++] = arr[left++];
            }
        }

        // 정렬된 배열을 원래 배열에 복사
        for (int i = start ; i <= end ; i ++) {
            arr[i] = sorted[i];
        }
    }
}
