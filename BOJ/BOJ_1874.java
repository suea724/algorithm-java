import java.util.*;

public class BOJ_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine()); // 수열 개수
        int orderNum = 1; // 오름차 순으로 입력하기 위한 순서
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        // 배열 입력
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.valueOf(sc.nextLine());
        }

        for (int i = 0 ; i < arr.length ; i ++) {

            // 1부터 오름차순으로 stack에 저장
            while (orderNum <= arr[i]) {
                stack.push(orderNum++);
                sb.append("+");
                sb.append("\n");
            }

            // peek() 수행 시 현재 수와 일치하면 꺼냄
            while (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
                sb.append("-");
                sb.append("\n");
            }
        }

        // 스택에 남아있는 값이 있으면 NO 출력
        if (!stack.isEmpty()) {
            sb = new StringBuilder("NO");
        }

        System.out.println(sb.toString());
    }
}
