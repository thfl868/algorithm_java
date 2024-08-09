package com.example.algorithm.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class bj1753_최단경로{
    static List<Node>[] nodes;
    static boolean[] check;
    static int[] distance;
    public static void main(String[] args)throws IOException {
        /**
         다익스트라 알고리즘

         구현방법
         1. 출발점으로부터의 최단거리를 저장할 배열 d[v]를 만들고, 출발 노드에는 0을, 출발점을 제외한 다른 노드들에는 매우 큰 값 INF를 채워 넣는다. 보통 d의 원소 타입에 대한 최대값으로 설정
         2. 현재 노드를 나타내는 변수 A에 출발 노드의 번호를 저장한다.
         3. A로부터 갈 수 있는 임의의 노드 B에 대해, d[A] + P[A][B][4]와 d[B][5]의 값을 비교한다. INF와 비교할 경우 무조건 전자가 작다.
         4. 만약 d[A] + P[A][B]의 값이 더 작다면, 즉 더 짧은 경로라면, d[B]의 값을 이 값으로 갱신시킨다.
         5. A의 모든 이웃 노드 B에 대해 이 작업을 수행한다.
         6. A의 상태를 "방문 완료"로 바꾼다. 그러면 이제 더 이상 A는 사용하지 않는다.
         7. "미방문" 상태인 모든 노드들 중, 출발점으로부터의 거리가 제일 짧은 노드 하나를 골라서 그 노드를 A에 저장한다.
         8. 도착 노드가 "방문 완료" 상태가 되거나, 혹은 더 이상 미방문 상태의 노드를 선택할 수 없을 때까지, 3~7의 과정을 반복한다.

         간단 설명
         1) 아직 방문하지 않은 정점 중 출발지로 부터 가장 거리가 짧은 정점을 방문한다.
         2) 해당 정점을 거쳐 갈 수 있는 정점의 거리가 이전 기록한 값보다 적으면 갱신한다.

         시간 복잡도
         이진 힙을 이용해 구현한 우선순위 큐의 경우 삽입/수정에 O(lg N) 출력에 O(lg N)

         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vAndE = br.readLine().split(" ");
        int v = Integer.parseInt(vAndE[0]);
        int e = Integer.parseInt(vAndE[1]);
        nodes = new ArrayList[v+1];
        check = new boolean[v+1];
        distance = new int[v+1];

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i <= v; i++){
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++){
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to, value));
        }

        StringBuilder sb = new StringBuilder();
        dij(start);
        for (int i = 1; i <=v; i++){
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dij(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[start] = 0;
        q.offer(new Node(start,0)); //자기자신 큐에 넣기

        while (!q.isEmpty()){
            Node cur = q.poll(); //우선순위 큐이므로 가장 작은 값을 가진게 먼저 나오게됨!! (최단거리)
            check[cur.end] = true; //방문 체크
            for(Node node : nodes[cur.end]){ //연결된 노드 체크
                if (!check[node.end]){ //방문하지 않은 곳인 경우
                    if (distance[cur.end] + node.cost < distance[node.end]){ //현재 저장된이동거리+ 방문하려는곳 이동 거리 < 방문하려는곳에 저장된 거리
                        distance[node.end] = distance[cur.end] + node.cost; //최솟값 갱신
                        q.offer(new Node(node.end, distance[node.end])); //큐에 넣기
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    public int end;
    public int cost;

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
    //cost(=가중치)  중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}