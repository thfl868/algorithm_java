package com.example.algorithm.다익스트라;
import java.io.*;
import java.util.*;
public class bj17396_백도어 {
    public static int n, m;
    public static int[] see ;
    public static ArrayList<Node1>[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        see = new int[n];
        arr = new ArrayList[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            see[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n;i++){
            arr[i] = new ArrayList<>();
        }

        //초기화
        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[a].add(new Node1(b,t));
            arr[b].add(new Node1(a,t));
        }


        Dijkstra(0);



    }

    //다익스트라 수행
    public static void Dijkstra(int start){
        boolean[] visited = new boolean[n]; //방문
        long[] dist = new long[n]; // 최단거리 저장
        PriorityQueue<Node1> pq = new PriorityQueue();

        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node1(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node1 q = pq.poll();
            if (visited[q.node]) continue; // 방문 체크
            visited[q.node] = true; //방문표시.
            //이웃노드 방문하기.
            for(Node1 next : arr[q.node]){
                //근데 안보이는 곳으로만 가야함.
                // 방문한 노드이거나 보이지 않는 노드인 경우 건너뛰기
                if (visited[next.node]) continue;
                if (next.node != n - 1 && see[next.node] == 1) continue;
                if(dist[next.node] > dist[q.node] + next.weight){
                    dist[next.node] = dist[q.node] + next.weight; //최소값 갱신.
                    pq.offer(new Node1(next.node,dist[next.node]));
                }
            }


        }

        System.out.println(dist[n-1] == Integer.MAX_VALUE ? "-1": dist[n-1]);

    }



}
class Node1 implements Comparable<Node1> {
    int node;
    long weight;
    Node1(int node,long weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1 o) {
        return Long.compare(this.weight ,o.weight );
    }
}