import java.util.Scanner;

public class Main {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int R = sc.nextInt(); // 행
		int C = sc.nextInt(); // 열
		
		int size = (int)(Math.pow(2, N)); // 한 변의 길이
		
		zSearch(size, R, C);
		
		System.out.println(count);
	}
	
	public static void zSearch(int size, int r, int c) {
		
		if (size == 1) {
			return;
		}
		
		int newSize = size / 2;
		
		if (r < newSize && c < newSize) { // 2사분면
			zSearch(newSize, r, c);
			
		} else if (r < newSize && c >= newSize) { // 1사분면
			count += (int)Math.pow(newSize, 2);
			zSearch(newSize, r, c - newSize);
			
		} else if (r >= newSize && c < newSize) { // 3사분면
			count += (int)Math.pow(newSize, 2) * 2;
			zSearch(newSize, r - newSize, c);
			
		} else { // 4사분면
			count += (int)Math.pow(newSize, 2) * 3;
			zSearch(newSize, r - newSize, c - newSize);
		}
	}
	
}
