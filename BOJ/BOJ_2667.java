import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {

    static int width = 0; // 한변 길이
    static int[][] graph; // 그래프
    static int[] moveX = {0, 0, -1, 1}; // x축 이동
    static int[] moveY = {1, -1, 0, 0}; // y축 이동
    static boolean[][] visited; // 방문 배열
    static int houseCount = 0; // 단지 당 집 수 (dfs 연쇄 호출 횟수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        width = Integer.parseInt(br.readLine());
        graph = new int[width][width];
        visited = new boolean[width][width];

        int houseGroup = 0; // 단지 수 (dfs 호출 횟수)
        ArrayList<Integer> houseCountList = new ArrayList<>();
        
        // 그래프 저장
        for (int i = 0 ; i < width ; i ++) {
            String input = br.readLine();
            for (int j = 0 ; j < width ; j ++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        // 그래프 요소마다 dfs 호출
        for (int i = 0 ; i < width ; i ++) {
            for (int j = 0 ; j < width ; j ++) {
                // 노드가 존재하면서 방문하지 않았을 때 dfs 호출
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfsSearch(i, j);
                    houseCountList.add(houseCount);
                    houseGroup++;
                    houseCount = 0;
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(houseCountList);

        // 출력
        System.out.println(houseGroup);
        for (int a : houseCountList) {
            System.out.println(a);
        }
        
    }

    // dfs 탐색
    private static void dfsSearch(int x, int y) {
        visited[x][y] = true; // 방문 처리
        houseCount ++;

        // 상하좌우 이동하면서
        for (int i = 0 ; i < 4 ; i ++) {
            int tempX = x + moveX[i];
            int tempY = y + moveY[i];
            
            // graph 인덱스에 속하면서, 노드가 존재하는데 방문하지 않은 노드이면 dfs 연쇄 호출
            if (tempX >= 0 && tempX < width && tempY >= 0 && tempY < width) {
                if (graph[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    dfsSearch(tempX, tempY);
                }
            }
        }
    }
}
