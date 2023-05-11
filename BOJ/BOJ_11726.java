import java.util.Scanner;

public class BOJ_11726 {
    
    static int[] dp; // Memoization할 배열을 전역변수로 선언
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		
		System.out.println(tiling(n));
    }
    
    public static int tiling(int num) {
			
		if (num <= 2) { // 1 또는 2이면 그대로 반환
			return num;
		}
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3 ; i <= num ; i ++) { // 3이상이면 계산 후 배열에 저장
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		return dp[num];

	}
}