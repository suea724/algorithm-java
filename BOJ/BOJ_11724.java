import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.valueOf(st.nextToken()); // 노드 개수
        int vertexCount = Integer.valueOf(st.nextToken()); // 간선 개수

        // 그래프 및 방문 노드 초기화
        graph = new ArrayList[nodeCount+1];
        visited = new boolean[nodeCount+1];

        for (int i = 1 ; i <= nodeCount ; i ++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 저장
        for (int i = 0 ; i < vertexCount ; i ++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.valueOf(st.nextToken());
            int node2 = Integer.valueOf(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        // dfs 실행 횟수 == 연결 요소 개수
        for (int i = 1 ; i <= nodeCount ; i ++) {
            if (!visited[i]) {
                dfs(i);
                answer ++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int startNode) {
        visited[startNode] = true;
        for (int i = 0 ; i < graph[startNode].size() ; i ++) {
            int tempNode = graph[startNode].get(i);
            // 방문하지 않은 노드이면 dfs 탐색 계속
            if (!visited[tempNode]) {
                dfs(tempNode);
            }
        }
    }
}