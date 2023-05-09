import java.util.*;

public class BOJ_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine()); // 수의 갯수
        int M = Integer.valueOf(sc.nextLine()); // 완성되는 번호의 합
        int[] materials = new int[N];

        for (int i = 0 ; i < N ; i ++) {
            materials[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(materials);

        int count = 0;
        int start = 0;
        int end = materials.length - 1;

        sc.nextLine();

        while (start < end) {
            int sum = materials[start] + materials[end];
            if (sum == M) { // 두 수의 합이 M과 같으면, count 추가 후 start, end 인덱스를 각각 뒤로, 앞으로 한칸씩 이동
                count ++;
                start ++;
                end --;
            } else if (sum < M) { // 두 수의 합이 M보다 작으면, 작은 쪽의 start 인덱스를 뒤로 한칸 이동
                start ++;
            } else { // 두 수의 합이 M보다 크면, 큰 쪽의 end 인덱스를 앞으로 한칸 이동
                end --;
            }
        }
        System.out.println(count);
    }
    
}
