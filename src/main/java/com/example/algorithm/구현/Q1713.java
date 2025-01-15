package com.example.algorithm.구현;
import java.util.*;
public class Q1713 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cand = sc.nextInt();
        int[] result = new int[n];
        int[] cnt = new int[n];
        int[] recent = new int[n];
        int idx = 0;
        for (int i = 0; i < cand; i++) {
            int nc = sc.nextInt();
            boolean flag = true;

            //틀이 비어있거나 후보가 있다면 채우기.
            for(int j=0; j<n;j++){
                if(result[j] == 0){
                    result[j] = nc;
                    cnt[j] = 1;
                    recent[j] = idx++;
                    flag = false;
                    break;
                }else if( result[j] == nc){
                    cnt[j]++;
                    flag = false;
                    break;
                }
            }
            // 다 돌았는데도 자리가 없으면 삭제해야함.
            if(flag){
                List<Integer> list = new ArrayList<>();
                int min = n;
                for(int j=0; j<n;j++){
                    if(min > cnt[j]){
                        min = cnt[j];
                    }
                }
                //인덱스 1개라면 해당 사진 삭제하고 넣기
                for(int j=0; j<n;j++){
                    if(min == cnt[j]){
                        list.add(j);
                    }
                }
                if(list.size() == 1){
                    int a = list.get(0);
                    cnt[a] = 0;
                    result[a] = nc;
                    cnt[a] = 1;
                    recent[a] = idx++;
                }else if( list.size() > 1){
                    int mv = Integer.MAX_VALUE;
                    int a = 0;
                    for(int b : list){
                        if(recent[b]<mv){
                            mv = recent[b];
                            a = b;
                        }
                    }
                    cnt[a] = 0;
                    result[a] = nc;
                    cnt[a] = 1;
                    recent[a] = idx++;
                }
                //인덱스 2개이상이라면 오래된 사진 삭제하고 넣기

            }

        }
        Arrays.sort(result);

        for(int j=0; j<n;j++) {
            System.out.print(result[j] + " ");
        }
    /**
 * 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
 * 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
 * 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시한다. 이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
 * 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
 * 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
 * */

    }

}
