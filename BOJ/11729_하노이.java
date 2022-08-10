import java.util.*;

public class Main {
    
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
		// 이동 횟수는 2^n - 1
        sb.append((int)(Math.pow(2, n)) - 1 + "\n");
        hanoiProcess(n, 1, 2, 3);
        
        System.out.println(sb);
    }
    
    public static void hanoiProcess(int n, int start, int mid, int to) {
		
		if (n == 1) {
            sb.append(start + " " + to + "\n");
			return;
		} 
		
		// 1 -> 3으로 옮긴다고 가정할 때,
		
		// STEP 1 : N-1개를 1 -> 2로 이동
		hanoiProcess(n - 1, start, to, mid);
		
		// STEP 2 : 1개를 3 -> 1로 이동
        sb.append(start + " " + to + "\n");
		
		// STEP 3 : N-1개를 2 -> 3로 이동
		hanoiProcess(n - 1, mid, start, to);
		
	}

}