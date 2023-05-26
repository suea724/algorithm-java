import java.util.*;

public class BOJ_17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.valueOf(sc.nextLine());
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 stack
        int[] arr = new int[size]; // 입력받을 수열
        int[] res = new int[size]; // 오큰수 결과를 저장할 배열
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < size ; i ++) {
            arr[i] = sc.nextInt();

            // 값 초기화
            res[i] = -1;
        }

        // 스택에 첫번째 값의 인덱스 입력
        stack.push(0);

        for (int i = 1 ; i < arr.length ; i ++) {
            // 스택에 값이 존재하고, 스택의 값보다 현재 값이 크면 pop, 작으면 push
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.pop()] = arr[i];
            } 
            stack.push(i);
        }

        // 결과 문자열 생성
        for (int i = 0 ; i < res.length ; i ++) {
            if (i == res.length-1) {
                sb.append(res[i]);
                break;
            }
            sb.append(res[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
