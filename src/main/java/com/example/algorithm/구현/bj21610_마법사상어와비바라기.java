package com.example.algorithm.구현;
import java.io.*;
import java.util.*;
public class bj21610_마법사상어와비바라기 {
    //8개 이동방향 : ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] move_x= {0,-1,-1,-1,0,1,1,1};
    static int[] move_y= {-1,-1,0,1,1,1,0,-1};
    static int[][] land ;
    static boolean[][] cloud ;
    static int  N, M ,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        land = new int[N + 1][N + 1];
        cloud = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken()); //바구니 초기화
            }
        }
        //구름 초기화 (N, 1), (N, 2), (N-1, 1), (N-1, 2)
        cloud[N][1] = true;
        cloud[N][2] = true;
        cloud[N-1][1] = true;
        cloud[N-1][2] = true;

        for(int i=0;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); //방향
            int s = Integer.parseInt(st.nextToken()); //거리
            magic(d-1,s);
        }
        count();
    }
    static void count(){
        int cnt = 0;
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                cnt += land[i][j];
            }
        }
        System.out.println(cnt);
    }
    static void magic(int d, int s){
        //모든 구름이 di 방향으로 si칸 이동한다.
        cloud = move_cloud(move_x[d] * s, move_y[d] * s);
        //각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
        rain();
        //구름이 모두 사라진다.

        //2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
        // 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
        //이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
        //예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
        copy_water();

        //바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
        cloud = make_cloud();

    }
    static void print_land(){

        System.out.println("-----print_land-----");
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(land[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("------------------");
        System.out.println();
    }
    static void print_cloud(){

        System.out.println("-----print_cloud-----");
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(cloud[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println();

    }

    static boolean[][] make_cloud(){
        //구름이 있던 칸을 제외한 곳에서 물의 양이 2인 곳에 새로운 구름 생성
        boolean[][] new_cloud = new boolean[N+1][N+1];
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                if(!cloud[i][j]){
                    if(land[i][j] >= 2){
                        new_cloud[i][j] = true;
                        land[i][j] =  land[i][j]-2;
                    }
                }
            }
        }

        return new_cloud;
    }
    static void copy_water(){
        //구름이 있던 칸의 대각선 방향에 물이 1이상이면 cnt ++ 하기
        for(int i=1;i<=N;i++) {
            for (int j=1; j <= N; j++) {
                if(cloud[i][j]){ //구름있던 땅
                    int cnt = 0;
                    //사방 대각선 확인해서 물있는지 확인.
                    for(int k=1; k<8; k=k+2){
                        int nx = move_x[k]+i;
                        int ny = move_y[k]+j;
                        if(nx>=1 && nx <=N){
                            if( ny >=1 && ny <=N) {
                                if (land[nx][ny] > 0) cnt++; //물 있으면 카운트
                            }
                        }
                    }
                    land[i][j] += cnt; //물 존재하던 칸 만큼 숫자 더해주기
                }

            }
        }
    }

    static void rain(){
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                if(cloud[i][j]){
                    land[i][j]++;
                }
            }
        }
    }

    static boolean[][] move_cloud(int x, int y ){
        //구름을 x, y 만큼씩 이동시킨 새 구름 만들기
        boolean[][] new_cloud = new boolean[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(cloud[i][j]){ //구름이 있다면 이동하기
                   int ni = (i+x)% N ;
                   int nj = (j+y)% N;
                   if(ni <= 0){
                       ni = ni +N;
                   }
                    if(nj <= 0){
                        nj = nj+N;
                    }

                    new_cloud[ni][nj] = true;
                }
            }
        }
        return new_cloud;
    }
}
