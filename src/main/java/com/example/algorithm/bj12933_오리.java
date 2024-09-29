package com.example.algorithm;

import java.io.*;
import java.util.*;
public class bj12933_오리 {
    static int max;
    static List<List<Character>> ducklist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        max = 0;
        ducklist = new ArrayList<>();

        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            boolean b = cntDuck(c);
            if (!b) {
                max = -1;
                break;
            }
        }

        // 모든 오리가 완성되었는지 확인
        if (max != -1) {
            for (List<Character> duck : ducklist) {
                if (duck.size() != 5) { // 'quack'의 길이
                    max = -1;
                    break;
                }
            }
        }

        System.out.println(max);
    }

    static boolean cntDuck(char c) {
        int len = ducklist.size();
        boolean flag = false;

        if (c == 'q') { // 새로운 오리 시작
            ducklist.add(new ArrayList<>());
            ducklist.get(ducklist.size() - 1).add(c);
            flag = true;
        } else {
            for (int i = 0; i < len; i++) {
                List<Character> duck = ducklist.get(i);
                int size = duck.size();

                if ((size == 1 && c == 'u') || (size == 2 && c == 'a') || (size == 3 && c == 'c')) {
                    duck.add(c);
                    flag = true;
                    break;
                } else if (size == 4 && c == 'k') {
                    duck.add(c);
                    ducklist.remove(i); // 오리 완성
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) { // 들어갈 데가 없으면
            if (c == 'q') { // 새로운 오리 추가
                ducklist.add(new ArrayList<>());
                ducklist.get(ducklist.size() - 1).add(c);
                flag = true;
            }
        }

        max = Math.max(max, ducklist.size()); // 최대 오리 수 업데이트
        return flag;
    }
}