package com.example.algorithm.시험;
import java.io.*;
import java.util.*;
public class bj1759_암호만들기 {
    static int L, C;
    static String[] password;
    static boolean[] visited;
    static String[] alpha;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        L = Integer.parseInt(str[0]); //알파벳 갯수
        C = Integer.parseInt(str[1]); //암호 구성 갯수

        StringTokenizer st =  new StringTokenizer(br.readLine());
        alpha = new String[C];
        visited = new boolean[C];

        for(int i=0; i<C; i++){
            alpha[i] = st.nextToken();
        }
        Arrays.sort(alpha);
        sb =  new StringBuilder();
        password= new String[L];
        func(0,0);

        System.out.print(sb);




    }
    static void func(int n, int now){
        //알파벳 총 n개중에서 L개 뽑기.
        // a, e, i, o, u 중에 1개 이상 있는지 확인하고 넣기.
        // 전체 단어 갯수 - 모음갯수 >= 2 이상 자음갯수 2개 이상인지 확인
        if(n == L) {
            int cnt = 0;
            StringBuilder s = new StringBuilder();
            Arrays.sort(password);

            for(int i=0; i<password.length;i++){
                s.append(password[i]);
                if("a".equals(password[i])||"e".equals(password[i])|| "i".equals(password[i]) || "o".equals(password[i]) || "u".equals(password[i]) ){
                    cnt++;
                }

            }
            if(cnt >0 && L-cnt >=2){ //모음 있을때만
                sb.append(s+"\n");
            }
        }else {
            //알파벳 순서로 정렬하고 string Builder 에 넣기.

            for (int i = now; i < alpha.length; i++) {
                if (!visited[i]) {
                    visited[i] = true; //방문 표시
                    password[n] = alpha[i]; //패스워드 넣기
                    func(n + 1, i + 1);
                    visited[i] = false; //방문 표시 초기화
                }
            }
        }

    }
}