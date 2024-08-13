package com.example.algorithm.구현;

import java.io.*;
class bj5212_지구온난화 {
        static int r,c;
        static char[][] matrix ;
        static char[][] new_matrix;
        static int[] x = {0,0,1,-1};
        static int[] y = {1,-1,0,0};
        static int min_x = Integer.MAX_VALUE;
        static int max_x = Integer.MIN_VALUE;
        static int min_y = Integer.MAX_VALUE;
        static int max_y = Integer.MIN_VALUE;
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] arr =br.readLine().split(" ");
            r = Integer.parseInt(arr[0]);
            c = Integer.parseInt(arr[1]);
            matrix = new char[r][c];
            new_matrix = new char[r][c];
            for(int i=0;i<r;i++){
                String str = br.readLine();
                for(int j=0;j<c;j++){
                    matrix[i][j] = str.charAt(j);
                }
            }

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    char now = matrix[i][j];
                    if(now == 'X'){
                        new_matrix[i][j] = check(now,i,j);
                    }else{
                        new_matrix[i][j] = now;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=min_x;i<=max_x;i++){
                for(int j=min_y;j<=max_y;j++){
                    sb.append(new_matrix[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);

        }

        public static char check(char now,int i,int j){
            //동서남북 바다 or 0보다 작거나 크면 바다
            int count = 0;
            for(int k=0;k<4;k++){

                //바다인지 확인
                int nx = i+x[k];
                int ny = j+y[k];
                if(nx<0||ny<0||nx>=r||ny>=c){
                    count++;
                    continue;
                }
                if(matrix[nx][ny] == '.'){
                    count++;
                }


            }

            //3면이상 바다면 잠김
            if(count >=3){
                return '.';
            }else{
                max_x = Math.max(max_x,i);
                min_x = Math.min(min_x,i);
                max_y = Math.max(max_y,j);
                min_y = Math.min(min_y,j);
                return now;
            }
        }

}

