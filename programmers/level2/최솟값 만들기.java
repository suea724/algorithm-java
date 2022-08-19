import java.util.*;

class Solution
{
    public int solution(int []A, int []B) {
        
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 최솟값 * 최댓값의 합 => 누적 곱의 합의 최솟값
        for (int i = 0 ; i < A.length ; i ++) {
            answer += A[i] * B[A.length-i-1];
        }

        return answer;
    }
}