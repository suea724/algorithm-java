
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {
    public static ArrayList<Integer>[] graph;
    public static int answer = 0;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.valueOf(br.readLine()); // 컴퓨터 수
        int vertexCount = Integer.valueOf(br.readLine()); // 컴퓨터 쌍의 수

        // 리스트 초기화
        graph = new ArrayList[nodeCount+1];

        for (int i = 1 ; i < graph.length ; i ++) {
            graph[i] = new ArrayList<>();
        }

        // 방문 배열 초기화
        visited = new boolean[nodeCount+1];

        // 그래프 저장
        for (int i = 0 ; i < vertexCount ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.valueOf(st.nextToken());
            int node2 = Integer.valueOf(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        // 1번 컴퓨터를 시작으로, dfs 탐색 횟수 구하기
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 0 ; i < graph[node].size() ; i ++) {
            if (!visited[graph[node].get(i)]) {
                dfs(graph[node].get(i));
                answer ++; // dfs 수행할 때마다 횟수 추가
            }
        }
    }
}
