import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연결 요소 찾는 문제.
 * 노드의 연결 정보가 아닌 좌표 정보가 주어짐.
 */
public class BOJ_1012 {

    // 쌍으로 상하좌우 움직임을 나타낼 배열
    public static int[] moveX = {0, 0, -1, 1};
    public static int[] moveY = {1, -1, 0, 0};

    public static int width = 0; // 가로
    public static int height = 0; // 세로
    public static int cabbageCount = 0; // 배추 수
    public static int[][] map; // 배추 좌표 배열
    public static boolean[][] visited; // 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.valueOf(br.readLine());

        // 테스트 케이스 개수만큼 반복
        for (int i = 0 ; i < testCase ; i ++) {
            // 가로, 세로, 배추 수 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.valueOf(st.nextToken());
            height = Integer.valueOf(st.nextToken());
            cabbageCount = Integer.valueOf(st.nextToken());
            
            // 배추 좌표 배열 및 방문 배열 초기화
            map = new int[width][height];
            visited = new boolean[width][height]; 
            int answer = 0;

            // 그래프 저장
            for (int j = 0 ; j < cabbageCount ; j ++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
                map[x][y] = 1;
            }
            
            // dfs
            // for (int j = 0 ; j < width ; j ++) {
            //     for (int k = 0 ; k < height ; k ++) {
            //         if (map[j][k] == 1 && !visited[j][k]) {
            //             dfs(j, k);
            //             answer ++; // dfs 실행 횟수
            //         }
            //     }
            // }

            // bfs
            for (int j = 0 ; j < width ; j ++) {
                for (int k = 0 ; k < height ; k ++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                        answer ++; // bfs 실행 횟수
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int x, int y) {
        // 방문 표시
        visited[x][y] = true;
        for (int i = 0 ; i < 4 ; i ++) {
            int tempX = x + moveX[i];
            int tempY = y + moveY[i];

            if (tempX >= 0 && tempY >= 0 && tempX < width && tempY < height) {
                // 배추가 존재하는데 방문하지 않은 경우
                if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
                    dfs(tempX, tempY);
                }
            }
        }
    }
    
    public static void bfs(int x, int y) {
        // 방문 표시
        visited[x][y] = true;

        // x좌표, y좌표를 저장할 큐 각각 정의
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(x);
        yQueue.offer(y);

        // 큐에 데이터가 존재할 때
        while (!xQueue.isEmpty() || !yQueue.isEmpty()) {
            int pollX = xQueue.poll();
            int pollY = yQueue.poll();

            // 상하좌우 각각 이동
            for (int i = 0 ; i < 4 ; i ++) {
                int tempX = pollX + moveX[i];
                int tempY = pollY + moveY[i];

                if (tempX >= 0 && tempY >= 0 && tempX < width && tempY < height) {
                    // 배추가 존재하는데 방문하지 않은 경우
                    if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
                        visited[tempX][tempY] = true; // 방문 표시
                        // 각 좌표 저장
                        xQueue.offer(tempX);
                        yQueue.offer(tempY);
                    }
                }
            }
        }
    }
}