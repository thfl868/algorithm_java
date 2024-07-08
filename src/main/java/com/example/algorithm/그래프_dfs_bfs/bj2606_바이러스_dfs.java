package com.example.algorithm.그래프_dfs_bfs;

import java.util.*;
public class bj2606_바이러스_dfs {
    /**
     * 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
     * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
     * 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
     * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
     *
     * 1번 컴퓨터가 바이러스 걸렸을 때, 1번과 연결되어있는 컴퓨터는 다 바이러스에 걸림
     * -> dfs로 풀기
     * 컴퓨터수가 최대 100대이므로 인접행렬, 인접리스트 둘 다 해도 100 미만임.
     * -> 인접행렬, 인접 리스트 둘 다 가능
     * */

    static int n;
    static int v;
    static int[][] adj;
    static boolean[] visited;
    static int cnt;

    public static void main(String args[]){
        input();
        dfs(1);
        System.out.println(cnt);
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = sc.nextInt();
        adj = new int[n+1][n+1];
        visited = new boolean[n+1];
        int x,y;
        for(int i=1; i<=v;i++){
            x = sc.nextInt();
            y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x){

        visited[x] = true; //방문한 노드 체크

        for(int i=1; i<=n; i++){
            if(visited[i]) continue; //방문한 곳은 넘어가기
            if(adj[x][i] == 1){ //연결되어있다면
                cnt++; //연결 수 체크
                dfs(i); //연결된 다음 노드 방문
            }
        }
    }
}
