package com.example.algorithm.그래프_dfs_bfs;

import java.util.*;
import java.io.*;
public class bj16234_인구이동_bfs {
    //todo 꼭 다시 풀어보기, 어려움 (골드 4 문제)
    /**
     * visit 배열 초기화 위치 중요!!
     * 하루에 두 연합 이상이 생성될 수 있음
     * for문 다 돌고 난다음에 visit 배열 초기화해야함.
     *
     * 1. 이중 포문으로 배열을 모두 돌면서 연합 확인하고, 연합국들은 list에 넣음
     * 2. 인구 이동 후 방문 배열 초기화하기.
     * 3. 인구 이동이 있었던 경우 하루 증가하기, 없는 경우 끝내기
     * 다시 while문으로 1-3을 반복 실행함.(인구이동 없을때까지 list의 길이가 1이상인게 없을때 까지)
     *
     * */
    public static void main(String args[])throws IOException{
        input();

        while(true){
            boolean flag = cal();
            init_visit();
            if(flag) cnt++;
            if(!flag) break;
        }
        System.out.println(cnt);
    }
    static int N,L,R;
    static int[][] land;
    static boolean[][] visited;
    static int[] x_list = {-1,1,0,0};
    static int[] y_list = {0,0,-1,1};
    static int people_cnt;
    static List<Country> list;
    static int cnt;

    static void input() throws IOException{
        cnt =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        land = new int[N][N];
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                land[i][j] = Integer.parseInt(st.nextToken());//각 나라의 인구수 저장

            }
        }
        init_visit(); // 방문 배열 초기화
    }

    static boolean cal(){
        //나라 국경선 확인하는 부분
        boolean hasMigration = false; // 인구 이동 여부를 체크하는 변수
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                if(!visited[i][j] ){
                    bfs(i,j);
                    if (list.size() > 1) {
                        migration(); //인구 나누기
                        hasMigration = true;
                    }
                }
            }
        }
        return hasMigration;
    }

    static void init_visit(){
        //visited 배열 초기화
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                visited[i][j] = false;
            }
        }
    }

    static void migration() {
        int list_cnt = list.size();
        int p = people_cnt / list_cnt; // 연합의 인구 수를 연합의 칸 수로 나누기
        for (Country c : list) {
            land[c.getX()][c.getY()] = p;
        }
    }
    static void bfs(int x, int y){
        people_cnt = land[x][y]; // 초기화
        list = new ArrayList<>(); // bfs 시작 시 초기화

        //해당 입력된 칸을 que에 넣고,
        Queue<Country> que = new LinkedList<>();
        que.offer(new Country(x,y));
        visited[x][y] = true;
        list.add(new Country(x, y));

        //이 칸에서 상하좌우 확인해서 연결 된 곳 있으면 인접리스트에 넣기.
        while(!que.isEmpty()){
            Country ctry = que.poll();
            for(int i=0;i<4;i++){
                int new_x = ctry.getX() + x_list[i];
                int new_y = ctry.getY() + y_list[i];

                if(new_x>=0&& new_x <N && new_y >=0 && new_y <N){ //범위내,
                    if(!visited[new_x][new_y]){
                        //인구 수 차이 확인하기
                        if (Math.abs(land[ctry.getX()][ctry.getY()] - land[new_x][new_y]) >= L &&
                                Math.abs(land[ctry.getX()][ctry.getY()] - land[new_x][new_y]) <= R) {

                            //리스트에 넣기. 넣어야할것 -> 한 나라인지? bfs내에는 다 한나라임
                            //해당 나라 위치, 인구수..
                            que.offer(new Country(new_x, new_y));
                            visited[new_x][new_y] = true; // 방문 표시
                            list.add(new Country(new_x, new_y));
                            people_cnt+=land[new_x][new_y];

                        }
                    }
                }

            }
        }
    }

    static class Country{
        int x;
        int y;
        public Country(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }
}
