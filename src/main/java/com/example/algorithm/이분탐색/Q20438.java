package com.example.algorithm.이분탐색;
import java.io.*;
import java.util.*;
public class Q20438 {
    public static int  n,k,q,m,cnt;
    public static int[]  kArr, qArr;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());
        //1번째 줄에 학생의 수 N, 졸고 있는 학생의 수 K, 지환이가 출석 코드를 보낼 학생의 수 Q, 주어질 구간의 수 M
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        kArr = new int[k];
        qArr = new int[q];
        st = new StringTokenizer( br.readLine());
        //각각 K명의 졸고 있는 학생의 입장 번호들과
        for(int i=0; i<k;i++){
            kArr[i] =  Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer( br.readLine());
        //Q명의 출석 코드를 받을 학생의 입장 번호
        for(int i=0; i<q;i++){
            qArr[i] =  Integer.parseInt(st.nextToken());
        }
        //M개의 줄 동안 구간의 범위 S, E가 공백을 사이에 두고 주어진다. (3 ≤ S < E ≤ N + 2)
        for(int i=0;i<m;i++){
            st = new StringTokenizer( br.readLine());
            int start =  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            check(start, end);
        }

    }

    public static void check(int start, int end){
        cnt += end-start+1;

        //졸고있는 학생이거나 그의 배수만큼 빼기
        for(int j=0; j<k; j++){
            int K = kArr[j];
            int a = start/K;
            int b = end/K;
            int sum = b-a;
            cnt -= sum;
        }
        //출석코드 받은 사람이거나 그의 배수이면 cnt에서 빼기.
        //졸고있는 학생이거나 그의 배수만큼 빼기
        for(int j=0; j<k; j++){
            int K = kArr[j];
            int a = start/K;
            int b = end/K;
            int sum = b-a;
            cnt -= sum;
        }


    }
}
