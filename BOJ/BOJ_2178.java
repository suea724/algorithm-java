import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    // 상하좌우 이동을 나타내기 위한 배열
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()); // 세로
        int w = Integer.parseInt(st.nextToken()); // 가로
        graph = new int[h][w];
        visited = new boolean[h][w];

        // 입력값 그래프에 저장
        for (int i = 0 ; i < h ; i ++) {
            String inputStr = br.readLine();
            for (int j = 0 ; j < w ; j ++) {
                graph[i][j] = inputStr.charAt(j) - '0';
            }
        }

        // 최소 이동 횟수 - BFS 사용
        bfsSearch(h, w);
        System.out.println(graph[h-1][w-1]);
    }

    // (0,0) ~ (x,y)까지 최소 이동 횟수
    private static void bfsSearch(int x, int y) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        // (0,0) 방문처리
        xQueue.add(0);
        yQueue.add(0);
        visited[0][0] = true;

        while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
            int pollX = xQueue.poll();
            int pollY = yQueue.poll();

            // 상하좌우 이동
            for (int i = 0 ; i < 4 ; i ++) {
                int tempX = pollX + moveX[i];
                int tempY = pollY + moveY[i];

                // 그래프 인덱스 조건을 만족하고
                if (tempX >= 0 && tempX < x && tempY >= 0 && tempY < y) {
                    // 노드가 존재하는데 방문하지 않은 노드이면
                    if (graph[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                        xQueue.add(tempX);
                        yQueue.add(tempY);
                        visited[tempX][tempY] = true;

                        // 그래프에 (x,y) 도달 비용 저장
                        graph[tempX][tempY] += graph[pollX][pollY];
                    }
                }
            }
        }
    }
}