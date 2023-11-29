import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

    public class BOJ_13023 {
        static int n; // 사람 수
        static int m; // 친구 관계 수
        static ArrayList<Integer>[] graph; // 그래프
        static boolean[] visited; // 방문 배열
        static int answer = 0; 
        
        public static void main(String[] args) throws IOException {
            // 하나의 연결 요소에 노드 개수가 m개 이상일 때 1 출력, 외에 0 출력
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n];
            visited = new boolean[n];

            for (int i = 0 ; i < n ; i ++) {
                graph[i] = new ArrayList<>();
            }
            
            // 그래프 저장
            for (int i = 0 ; i < m ; i ++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            // 요소마다 DFS 호출
            for (int i = 0 ; i < n ; i ++) {
                if (answer == 1) break;
                System.out.println("i = " + i);
                dfsSearch(i, 0);
            }

            System.out.println(answer);
        }

        // DFS
        public static void dfsSearch(int node, int depth) {
            // 4 이상일 때 DFS 호출 종료
            if (depth >= 4) {
                answer = 1;
                return;
            }

            // 방문 처리
            visited[node] = true;
            for (int i = 0 ; i < graph[node].size() ; i ++) {
                int tempNode = graph[node].get(i);
                if (!visited[tempNode]) {
                    // 이어서 DFS 연속 호출 시 depth 증가
                    dfsSearch(tempNode, depth+1);
                }
            }
            // depth 조건을 만족하지 않을 때, 재귀 호출이 끝나면 방문 해제 처리
            visited[node] = false;
        }
    }