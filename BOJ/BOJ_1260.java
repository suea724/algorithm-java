import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    public static StringBuilder dfsResult = new StringBuilder();
    public static StringBuilder bfsResult = new StringBuilder();
    public static int[][] graph; // 그래프를 저장할 이차원 배열
    public static boolean[] visited; // 방문 배열
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.valueOf(st.nextToken()); // 노드 개수
        int vertexCount = Integer.valueOf(st.nextToken()); // 간선 개수
        int startNode = Integer.valueOf(st.nextToken()); // 시작 노드

        // 그래프 및 방문 배열 초기화
        graph = new int[nodeCount+1][nodeCount+1];
        visited = new boolean[nodeCount+1];

        // 그래프 노드 저장
        for (int i = 0 ; i < vertexCount ; i ++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.valueOf(st.nextToken());
            int node2 = Integer.valueOf(st.nextToken());

            graph[node1][node2] = graph[node2][node1] = 1;
        }

        // dfs 결과 출력
        dfs(visited, startNode);
        System.out.println(dfsResult);

        // 방문 배열 초기화
        for (int i = 0 ; i < visited.length ; i ++) {
            visited[i] = false;
        }

        // bfs 결과 출력
        bfs(visited, startNode);
        System.out.println(bfsResult);
    }

    public static void dfs(boolean[] visited, int startNode) {
        visited[startNode] = true;
        dfsResult.append(startNode + " ");

        for (int i = 1 ; i < graph[startNode].length ; i ++) {
            // 간선이 존재하고, 방문하지 않은 노드면 탐색 계속
            if (graph[startNode][i] == 1 && !visited[i]) {
                dfs(visited, i);
            }
        }
    }

    public static void bfs(boolean[] visited, int startNode) {
        // 큐 정의
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 및 방문 배열
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int tempNode = queue.poll();
            bfsResult.append(tempNode + " ");
            for (int i = 1 ; i < graph[tempNode].length ; i ++) {
                // 간선이 존재하고, 방문하지 않은 노드면 탐색 계속
                if (graph[tempNode][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
