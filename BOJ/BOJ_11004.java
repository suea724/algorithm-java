import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11004 {

    static int k = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        
        // 배열에 저장
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        quickSort(arr, 0, arr.length-1);
        System.out.println(arr[k-1]);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotIndex = partition(arr, start, end);

        // pivot 인덱스와 k를 비교하여 정렬 범위 설정 후 재귀호출
        if (pivotIndex == k) { // k가 pivot 위치면 정렬 필요 X, 바로 k번째 값 반환 가능
            return;
        } else if (pivotIndex < k) { // k가 pivot 위치보다 크면 오른쪽만 정렬
            quickSort(arr, pivotIndex+1, end);
        } else { // k가 pivot 위치보다 작으면 왼쪽만 정렬
            quickSort(arr, start, pivotIndex-1);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // 중간값을 pivot으로 설정 후 맨 앞의 요소와 위치 교환
        int mid = (start + end) / 2;
        swap(arr, start, mid);

        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            // !! 두 while 문 위치가 바뀌면 답 틀림 !!
            // 오른쪽부터 pivot 값보다 작은 값을 찾을 때까지 --
            while (arr[right] > pivot) {
                right --;
            }

            // 왼쪽부터 pivot 값보다 큰 값을 찾을 때까지 ++
            while (arr[left] <= pivot && left < right) {
                left ++;
            }

            // 왼쪽에 pivot보다 큰 값, 오른쪽에 pivot보다 작은 값이 있는 경우 교환한다.
            swap(arr, left, right);
        }

        // left == right일 때, while문을 빠져나옴 > 왼쪽에는 pivot보다 작은 값, 오른쪽에는 pivot보다 큰 값이 위치한다.
        // pivot 값을 중간 위치로 이동
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    // 배열의 firstIndex와 secondIndex 위치에 있는 요소 교환
    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
