package com.example.algorithm.그래프_dfs_bfs;
import java.util.*;
import java.io.*;
public class bj14940_쉬운최단거리 {
    /**
     * 지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
     * 다음 n개의 줄에 m개의 숫자가 주어진다. 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.
     *
     * 목표지점인 n에서 모든 땅에 bfs로 방문해본다. 이동할때마다 +1 하기
     * */

    public static void main(String args[]) throws IOException{
        input();
        output();
    }
    static int[][] arr;
    static boolean[][] visited;
    static int[] move_x = {-1,1,0,0};
    static int[] move_y = {0,0,-1,1};
    static int n,m;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        int start_x = 0;
        int start_y = 0;

        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){ //배열 초기화
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        bfs(start_x,start_y);
    }

    static void output(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]){
                    sb.append(arr[i][j]+" ");
                }else{
                    if(arr[i][j] == 0) sb.append("0 ");
                    else sb.append("-1 ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x,y));
        arr[x][y] = 0; //출발지 0으로 만들기
        visited[x][y] = true; //방문표시

        while(!que.isEmpty()){
            Point now = que.poll();

            for(int i=0; i<4; i++) {
                int new_x = now.getX() + move_x[i];
                int new_y = now.getY() + move_y[i];
                if(new_x >=0 && new_x <n && new_y >=0 && new_y <m){ //범위 내인 경우
                    if(visited[new_x][new_y] ==false && arr[new_x][new_y] > 0) {
                        visited[new_x][new_y] = true;
                        arr[new_x][new_y] =  arr[now.getX()][now.getY()] +1;
                        que.offer(new Point(new_x, new_y));
                    }

                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return this.x;
        }
        int getY(){
            return this.y;
        }
    }
}
