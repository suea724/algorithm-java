import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

    static long[] trees; // 나무 길이 배열
    static long targetLength; // 최소 목표 길이

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCount = Integer.parseInt(st.nextToken());
        targetLength = Long.parseLong(st.nextToken());

        trees = new long[treeCount];
        st = new StringTokenizer(br.readLine());
        long max = 0; // 나무 최대 길이

        // 배열에 각 나무 길이 입력
        for (int i = 0 ; i < treeCount ; i ++) {
            trees[i] = Long.parseLong(st.nextToken());
            
            // 최댓값 저장
            if (trees[i] > max) max = trees[i];
        }

        long start = 0;
        long end = max;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;

            // 나무 길이 합 구하기.
            for (int i = 0 ; i < trees.length ; i ++) {
                sum += (trees[i] - mid > 0) ? trees[i] - mid : 0;
            }

            if (sum > targetLength) { // 나무 길이 합이 목표 길이보다 크면, 자르는 나무 길이를 늘려야 함.
                start = mid + 1;
            } else if (sum < targetLength) { // 나무 길이 합이 목표 길이보다 작으면, 자르는 나무 길이를 줄여야 함.
                end = mid - 1;
            } else { // 나무 길이 합이 목표 길이와 일치하면, mid값 반환
                System.out.println(mid);
                return;
            }
        }

        // 나무 길이 합이 목표 길이와 일치하지 않으면, 최선으로 end 값 출력
        System.out.println(end);
    }
}