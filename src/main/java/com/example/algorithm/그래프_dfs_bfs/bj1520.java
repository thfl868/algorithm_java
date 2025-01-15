package com.example.algorithm.그래프_dfs_bfs;
import java.util.*;
import java.io.*;
public class bj1520 {
    public static int[] moveX = {-1,1,0,0};
    public static int[] moveY = {0,0,-1,1};
    public static int[][]  arr, visited ;
    public static int n, m, cnt;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         arr = new int[n][m];
         visited = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }

        //0,0 에서 n,m 까지 가는 경로의 수 구하기.

        System.out.println(dfs(0,0));

    }
    public static int dfs(int x, int y){

        //끝나는 조건
        if(x == n-1 && y == m-1){
            return 1;
        }
        if (visited[x][y] == -1){
            visited[x][y] = 0;
            for(int i=0; i<4;i++){
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                if(nx >=0 && nx < n && ny >=0 && ny< m){
                    if(arr[nx][ny] < arr[x][y]) {
                        visited[x][y ]+= dfs(nx, ny);
                    }
                }
            }
        }
        return visited[x][y];
    }
}
