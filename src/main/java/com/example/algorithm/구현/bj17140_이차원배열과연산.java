package com.example.algorithm.구현;
import java.util.*;
import java.io.*;
public class bj17140_이차원배열과연산 {


    public static void main(String args[]) throws IOException {
        input();
        calculate();
    }

    static int r,c,k,cnt;
    static ArrayList<ArrayList> list;
    static ArrayList<Node> cnt_list;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = 0;
        list = new ArrayList<>();
        for(int i=0;i<3; i++){
            st = new StringTokenizer(br.readLine());
            ArrayList arr = new ArrayList<Integer>();
            for(int j=0;j<3;j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            list.add(arr);
        }
    }
    static class Node implements Comparable<Node>{
        public int num ;
        public int count;

        Node(int num , int count){
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
    /**
     * 1. A[r][c]에 k가 들어있는지 확인하고 들어있으면 시간초 프린트
     * 1. R 연산(+1초)
     * 2. C 연산(+1초)
     * R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
     * C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
     * 3. 행 또는 열 크기는 100 넘어가는 경우에 처음 100개 제외한 나머지 버림 (100초가 지나도 k 안되면 -1 출력)
     * 4. 크기가 커진 곳에 0 채워넣기.
     * */
    static void calculate(){
        while(true){

            // A[r][c]에 k가 들어있을때 종료
            // cnt 100 넘어가면 -1 출력후 종료

            //행과 열 중 어디가 큰지 확인
            if(compare()){
                //R연산
            }else{
                //C연산
            }
            cnt++;
        }
    }
    /**배열 A의 모든 행에 대해서 정렬을 수행한다.
     * 한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알아야 한다.
     * 그 다음, 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다.
     * 그 다음에는 배열 A에 정렬된 결과를 다시 넣어야 한다.
     * 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.*/
    static void calR(){
        //각각의 수가 몇번 나왔는지 체크
        for(int i=0; i<list.size();i++){
            for(int j=0; j<list.get(i).size(); j++){
                int c = (int) list.get(i).get(j);

            }
        }


        //숫자 , 등장 횟수 (등장횟수 오름차순, 숫자 오름차순)





    }

    static void calC(){

    }

    /**
     * 행과 열의 사이즈 비교하여 boolean retrun
     * 행 >= 열 return true
     * 행 < 열 retrun false*/
    static boolean compare(){

        int r = list.size();
        int c = list.get(0).size();
        if(r >= c) return true;
        else return false;

    }

    static void printList(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size();i++){
            for(int j=0; j<list.get(i).size();j++){
                sb.append(list.get(i).get(j)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
