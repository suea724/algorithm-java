import java.util.*;

public class BOJ_12891 {
    public static int[] tempArr = new int[4]; // 부분 문자열 문자 개수를 저장할 배열
    public static int[] condition = new int[4]; // A, C, G, T 비밀번호 조건
    public static int rightCount = 0; // 조건에 일치하는 문자 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); // 임의 DNA 문자열 길이
        int p = sc.nextInt(); // 비밀번호 문자열 길이
        sc.nextLine();
        String dna = sc.nextLine(); // 임의 DNA 문자열
        int answer = 0;

        // 비밀번호 조건 배열에 저장
        for (int i = 0 ; i < 4 ; i ++) {
            condition[i] = sc.nextInt();

            // 최소 조건이 0일 때, 조건 일치 문자 개수 추가
            if (condition[i] == 0) {
                rightCount ++;
            }
        }

        // 첫번째 부분 문자열
        for (int i = 0 ; i < p ; i ++) {
            add(dna.charAt(i));
        }

        // 4개의 문자가 일치하는 경우
        if (rightCount == 4) {
            answer ++;
        }
    
        // N번째 부분 문자열
        for (int i = 1 ; i <= s-p ; i++) {
            // 앞 원소 제거
            remove(dna.charAt(i-1));
            // 뒤 원소 추가
            add(dna.charAt(i+p-1));

            if (rightCount == 4) {
                answer ++;
            }
        }

        System.out.println(answer);
    }

    // 슬라이딩 윈도우 이동 시, 추가되는 원소 처리
    private static void add(char c) {
        switch (c) {
            case 'A' :
                tempArr[0]++;
                if (tempArr[0] == condition[0]) {
                    rightCount++;
                }
                break;
            case 'C' :
                tempArr[1]++;
                if (tempArr[1] == condition[1]) {
                    rightCount++;
                }
                break;
            case 'G' :
                tempArr[2]++;
                if (tempArr[2] == condition[2]) {
                    rightCount++;
                }
                break;
            case 'T' :
                tempArr[3]++;
                if (tempArr[3] == condition[3]) {
                    rightCount++;
                }
                break;
        }
    }

    // 슬라이딩 윈도우 이동 시, 제거되는 원소 처리
    private static void remove(char c) {
        switch (c) {
            case 'A' :
                if (tempArr[0] == condition[0]) {
                    rightCount--;
                }
                tempArr[0]--;
                break;
            case 'C' :
                if (tempArr[1] == condition[1]) {
                    rightCount--;
                }
                tempArr[1]--;
                break;
            case 'G' :
                if (tempArr[2] == condition[2]) {
                    rightCount--;
                }
                tempArr[2]--;
                break;
            case 'T' :
                if (tempArr[3] == condition[3]) {
                    rightCount--;
                }
                tempArr[3]--;
                break;
        }
    }
}
