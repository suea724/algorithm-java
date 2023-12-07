import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816 {
    static Map<Integer, Integer> cardMap; // 카드 번호와 갯수를 저장할 map
    static List<Integer> cardList; // cardMap의 keySet

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine()); // 카드 개수
        cardMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 번호와 갯수 map에 저장
        for (int i = 0 ; i < cardCount ; i ++) {
            int input = Integer.parseInt(st.nextToken());
            cardMap.put(input, cardMap.getOrDefault(input, 0)+1);
        }

        // map의 keySet 정렬
        cardList = new ArrayList<>(cardMap.keySet());
        Collections.sort(cardList);

        int targetCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 찾으려는 수
        for (int i = 0 ; i < targetCount ; i ++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()), 0, cardList.size()-1)).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 이진 탐색
    private static int binarySearch(int num, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (start + end) / 2; // 중간 인덱스
        
        if(num < cardList.get(mid)) { // 찾으려는 수가 중간값보다 작으면
            return binarySearch(num, start, mid-1);
        } else if(num > cardList.get(mid)) { // 찾으려는 수가 중간값보다 크면
            return  binarySearch(num, mid+1, end);
        } else { // 수를 찾으면 map에서 개수를 가져옴.
            return cardMap.get(num);
        }
    }
}