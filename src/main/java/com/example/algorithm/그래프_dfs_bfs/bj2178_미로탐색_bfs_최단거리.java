package com.example.algorithm.그래프_dfs_bfs;

import java.io.*;
import java.util.*;
public class bj2178_미로탐색_bfs_최단거리 {

    /**
     *(1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
     * bfs로 최단거리경로 찾기 (dfs로 찾을 경우, 하나를 끝까지 가보고 아니면 다시 돌아와서 탐색해야해서, 비효율)
     * 이동 할 때마다 이동하려는 칸의 숫자 +1씩 더해주기. (마지막 n,m에 도착했을때 해당 칸의 숫자가 최단 거리 숫자임.)
     * */

    public static void main(String args[])throws IOException{
        input();
        bfs(1,1); //1,1부터 시작
        System.out.println(arr[n][m]);

    }
    static int[] x_list = {-1,1,0,0};
    static int[] y_list = {0,0,-1,1};
    static int[][] arr;
    static int cnt = 0;
    static int n;
    static int m;
    static boolean[][] visited;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1;i<=n;i++) { //배열 초기화
            String str = br.readLine(); //한글자씩잘라서 넣기
            for(int j=1; j<=m; j++){
               arr[i][j]= str.charAt(j-1)-'0';
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            Location location = que.poll();
            //방문 안한곳이면 사방으로 이동해보고 갈 수 있으면 이동하기.
            for(int i=0; i<4; i++){
                int new_x = location.getX() + x_list[i];
                int new_y = location.getY() + y_list[i];
                if(new_x >=1 && new_x <= n & new_y >=1 && new_y <= m ){ //이동 범위 안에 있다면
                    if(arr[new_x][new_y] == 1 && !visited[new_x][new_y]) { //이동거리가 1이고, 방문 안했으면

                        que.offer(new Location(new_x, new_y));
                        visited[new_x][new_y] = true; //방문체크

                        arr[new_x][new_y] = arr[location.getX()][location.getY()] + 1; //최단거리 재기 위해 방문할곳은 +1씩 늘리기.
                    }
                }
            }
        }
    }

    static class Location{
        int x ;
        int y ;

        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
}
