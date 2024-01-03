import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2차원 Map, 시작 시간 기준으로 정렬하기 위해 TreeMap 사용
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int answer = 0;
        StringTokenizer st;

        // 회의 시간 입력받기
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken()); // 시작 시간
            int endTime = Integer.parseInt(st.nextToken()); // 종료 시간
            
            // map에 해당 키가 존재하면 리스트에 추가
            if (map.containsKey(startTime)) {
                map.get(startTime).add(endTime);
            } else { // map에 해당 키가 존재하지 않으면 리스트 생성해서 입력
                ArrayList<Integer> list = new ArrayList<>();
                list.add(endTime);
                map.put(startTime, list);
            }
        }

        Set<Integer> keySet = map.keySet();
        int prevStartTime = 0; // 이전 회의 시작 시간
        int prevEndTime = 0; // 이전 회의 종료 시간

        for (int currStartTime : keySet) {
            // 회의 종료 시간 오름차순 정렬
            Collections.sort(map.get(currStartTime));

            for (int i = 0 ; i < map.get(currStartTime).size() ; i ++) {
                int currEndTime = map.get(currStartTime).get(i);
                // 이전 회의 종료 시간보다 현재 회의 시작 시간이 늦으면 해당 회의 선택 후 회의 시간 업데이트
                if (prevEndTime <= currStartTime) {
                    answer ++;
                    prevStartTime = currStartTime;
                    prevEndTime = currEndTime;
                }

                // 더 효율적인 시간이 있으면 이전 회의 시간 업데이트
                if (prevStartTime <= currStartTime && prevEndTime > currEndTime) {
                    prevStartTime = currStartTime;
                    prevEndTime = currEndTime;
                }
            }
        }

        System.out.println(answer);
    }
}
