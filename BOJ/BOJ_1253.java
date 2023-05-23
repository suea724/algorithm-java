import java.util.*;

public class BOJ_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        int[] arr = new int[N];
        int count = 0;

        // 배열에 저장
        for (int i = 0 ; i < N ; i ++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        for (int i = 0 ; i < arr.length ; i ++) {
            int start = 0; // 시작 값
            int end = arr.length - 1; // 끝 값

            while (start < end) {
                int sum = arr[start] + arr[end]; // 두 수의 합

                if (sum == arr[i]) { 
                    if (start != i && end != i) { // 서로 다른 위치에 있는 수일때만 count 더하기
                        count++;
                        break;
                    } else if (end == i) { // end가 i와 같은 위치이면 앞으로 이동
                        end--;
                    } else if (start == i) { // start가 i와 같은 위치이면 뒤로 이동
                        start++;
                    }
                    
                } else if (sum > arr[i]) { // 합이 i 위치 수보다 크면 end를 앞으로 이동
                    end--;
                } else { // 합이 i 위치 수보다 작으면 start를 뒤로 이동
                    start++;
                }
            }
        }
        System.out.println(count);
    }
}