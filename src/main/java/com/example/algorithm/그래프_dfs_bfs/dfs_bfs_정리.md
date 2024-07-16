# 인접행렬 선언
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

int v = sc.nextInt();

int[][] adj = new int[n+1][n+1]; //인접행렬

visited = new boolean[n+1]; //방문배열

int x,y;

for(int i=1; i<=v;i++){

    int x = sc.nextInt();

    int y = sc.nextInt();

    adj[x][y] = 1; //양방향 그래프

    adj[y][x] = 1;
}


# 인접리스트 선언
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer>[] arr  = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>(); //인접 리스트배열 초기화
        }
        for(int i=1; i<+n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y); //방향성 없으므로 양쪽 다 넣기
            arr[y].add(x);
        }

# DFS(Depth First Search) : 깊이 우선 탐색
1. 시작점에서 아직 방문하지 않은 노드를 찾는다.
2. 방문하지 않은 노드가 있다면 Stack에 넣고 방문 표시를 한다.
3. 다음 노드로 이동한다.
4. 방문하지 않은 노드가 없다면 위로 올라간다. (Stack에서 노드를 꺼낸다.)

DFS가 유리한 문제
1) 경로 찾기: 단순히 두 지점 간의 경로가 존재하는지 여부를 찾을 때 DFS가 유용하다.
 목표 지점을 찾은 후에는 빠르게 종료 가능하다.
2) 깊이 우선 탐색이 필요한 경우: 그래프에서 깊이를 우선적으로 탐색해야 하는 경우 DFS가 유용하다.
ex. 트리에서 전위/중위/후위 순회를 수행할 때
3) 해결책의 수가 많은 경우: DFS는 해결책의 수가 많은 경우에 유용하다.
4) DFS를 이용한 순열, 조합 구현

# bfs
1. 시작점에서 아직 방문하지 않은 노드를 모두 찾아서 방문 표시를 하고 Queue에 넣는다.
2. Queue에서 노드를 꺼내 다음 노드로 진행한다.
3. 1~2번을 반복한다.

BFS가 유리한 문제
1) 최단 경로 찾기: 그래프에서 두 지점 사이의 최단 경로를 찾아야 할 때 BFS가 유용하다.
BFS는 너비 우선 탐색이므로 최단 경로를 찾는 데 효율적입니다.
2) 최소 비용 문제: 경로의 가중치가 주어진 경우에는 BFS가 최소 비용 경로를 찾는 데 효과적이다.
모든 경로를 탐색하지 않고 먼저 발견된 경로가 최단 경로임을 보장합니다.
3) 최단 경로가 유일한 경우: 최단 경로가 유일한 경우 BFS가 가장 효율적이다.
이 경우 BFS는 최단 경로를 찾는 데 시간복잡도가 더 낮습니다.
4) 상태 공간 탐색: 상태 공간에서 최소 이동/변경 횟수를 찾는 문제에는 BFS가 적합하다.
ex. 8 퍼즐, 스도쿠 등의 문제

# 트리
graph G(V, E)

트리란?
1. 모두가 연결 되어있는 그래프
2. 사이클이 존재하지 않아야 함.
3. 정점의개수 |V| = 간선의 개수 |E| + 1

Rooted Tree란?
1. Node : 정점
2. Root : 그래프의 뿌리가 되는 정점 (가장 위에 있는 정점)
3. Depth : 깊이 (root로부터의 거리)
4. parent(부모), child(자식), ancestor(조상), sibling(형제)
5. leaf node : 자식이 없는 노드

트리는 대부분 인접 리스트로 저장!
(공간복잡도 이슈 때문에 인접리스트 사용 추천)
트리는 dfs 알고리즘으로 접근 추천

