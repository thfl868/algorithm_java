package com.example.algorithm.그래프_dfs_bfs;
import java.io.*;
import java.util.*;
public class bj7569_토마토_bfs {

    //todo 다시 풀어보기!! 어려움
    /**
     * 1. 문제: 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
     * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
     * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 2. 문제를 푼 과정(생각 과정)
     * 익은 토마토 상하좌우앞뒤로 안익은 토마토를 익힐 수 있음.
     *  전체를 돌면서, 익은 토마토에서 이동할 수 있는 만큼 익히고, 일수 ++
     * 전체에서 이동할 수 있는 경우가 없을때까지 계속 반복하기.
     *
     * 3. 중요 개념(어떤 알고리즘/자료구조를 사용했는지, 시간복잡도는 얼마인지 등)
     * 수 작기때문에 인접행렬 사용가능
     * bfs ? dfs ? dfs로 전체 다 방문하기...
     * 첫째날: 모든 1의 위치의 상하좌우양옆에 방문해서 익히기.
     * 둘째날: 방문 안한 새로익은 1의 위치에서 상하좌우양옆 방문해서 익히기.
     * ...
     * 다익으면: 출력.
     *
     * 처음부터 익은 토마토를 큐에 넣기!!
     * */

    static int m,n,h;
    static int[][][] arr; //**3차원배열로 초기화하기
    static boolean[][][]  visited;//**3차원배열로 초기화하기
    static int min_day =0;

    static int[] x_list = {-1,1,0,0,0,0};
    static int[] y_list = {0,0,-1,1,0,0};
    static int[] z_list = {0,0,0,0,-1,1};
    static int unripe_count = 0;
    static Queue<Tomato> que;

    public static void main(String args[]) throws IOException {
        input();
        cal();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //5
        n = Integer.parseInt(st.nextToken());  //3
        h = Integer.parseInt(st.nextToken());
        que = new LinkedList<>();

        arr = new int[h][n][m] ;
        visited =  new boolean[h][n][m] ;
        for(int i=0; i<h;i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    visited[i][j][k] =false;
                    if (arr[i][j][k] == 0) {
                        unripe_count++;
                    }
                    if(arr[i][j][k] == 1){
                        //해당 토마토 큐에 넣기.
                        que.offer(new Tomato(j,k,i,0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

    }

    static void cal(){
    bfs();
//        for(int i=0; i<h;i++){
//            for(int j=0; j<n; j++){
//                for(int k=0; k<m; k++){
//                    //익은 토마토(1)로 부터 상하좌우양옆 안익은 토마토(0) 익히기
//                    if(arr[i][j][k] == 1 && !visited[i][j][k]){
//                        bfs(j,k,i);//x,y,z
//                    }
//                }
//            }
//        }


        if(unripe_count > 0 ){
           min_day = -1;
        }

    }

    static void output(){
        System.out.println(min_day);
    }

    static void bfs(){
//        //해당 토마토 큐에 넣기.
//        Queue<Tomato> que = new LinkedList<>();
//        que.offer(new Tomato(x,y,z,0));
//        visited[z][x][y] = true;

        while(!que.isEmpty()) {
            Tomato tomato = que.poll();
            //필드 상하좌우양옆 방문해서 토마토 익히기.
            for (int i = 0; i < 6; i++) {
                int new_x = tomato.getTomatoX() + x_list[i];
                int new_y = tomato.getTomatoY() + y_list[i];
                int new_z = tomato.getTomatoZ() + z_list[i];
                int next_day = tomato.getTomatoDay()+1 ;

                if(new_x >= 0 && new_y >=0 && new_z>=0){
                    if(new_x <n  && new_y <m && new_z <h){ //범위 내인 경우
                        //방문 안한 경우
                        if(visited[new_z][new_x][new_y]) continue; //방문 안한 경우
                        if(arr[new_z][new_x][new_y] == 0) {//토마토 안익은 경우 ** 0일때 안익은거임.
                            if (min_day < next_day) min_day = next_day; //날짜 갱신.
                            //방문해서 토마토 익히기.
                            que.offer(new Tomato(new_x, new_y, new_z, next_day));
                            visited[new_z][new_x][new_y] = true; //** 방문표시빠트림
                            unripe_count--;
                        }
                    }
                }
            }
        }
    }
    static class Tomato{
        int x;
        int y;
        int z;
        int day;

        Tomato(int x, int y, int z , int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
        int getTomatoX(){
            return this.x;
        }
        int getTomatoY(){
            return this.y;
        }
        int getTomatoZ(){
            return this.z;
        }
        int getTomatoDay(){
            return this.day;
        }
        String toStringTomato(){
            return "x:"+x +", y:"+y+", z:"+z+", day:"+day;
        }
    }
}
