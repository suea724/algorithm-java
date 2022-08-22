import java.util.*;

public class Main {
    public void main(String[] args) {
        
        // 자릿수와 수 입력받기
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String num = sc.nextLine();
        sc.close();
        
        // 합을 저장할 변수
        int sum = 0;
        
        // substring 연산하여 합 구하기
        for (int i = 0 ; i < n ; i ++) {
            sum += Integer.parseInt(num.substring(i, i+1));
        }
        
        System.out.println(sum);
    }
}