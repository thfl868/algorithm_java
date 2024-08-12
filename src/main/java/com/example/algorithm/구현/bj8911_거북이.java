package com.example.algorithm.구현;

import java.io.*;
import java.util.*;

class Main {
    static int x, y, max_x, min_x, max_y, min_y;
    static int directionIndex;
    static StringBuilder sb ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            x = 0;
            y = 0;
            max_x = 0;;
            min_x = 0;
            max_y = 0;
            min_y = 0;
            directionIndex = 0; // N 방향의 인덱스

            for (char command : line.toCharArray()) {
                move(command);
            }
            int extent = Math.abs(max_x - min_x) * Math.abs(max_y - min_y);
            sb.append(extent+"\n");
        }
        System.out.println(sb);
    }

    static void move(char command) {
        if (command == 'R') {
            directionIndex = (directionIndex + 1) % 4;
        } else if (command == 'L') {
            directionIndex = (directionIndex + 3) % 4;
        } else if (command == 'F') {
            if (directionIndex == 0) y++; // N
            else if (directionIndex == 1) x++; // E
            else if (directionIndex == 2) y--; // S
            else if (directionIndex == 3) x--; // W
        } else if (command == 'B') {
            if (directionIndex == 0) y--; // N
            else if (directionIndex == 1) x--; // E
            else if (directionIndex == 2) y++; // S
            else if (directionIndex == 3) x++; // W
        }

        // 최대/최소 좌표 갱신
        max_x = Math.max(max_x, x);
        min_x = Math.min(min_x, x);
        max_y = Math.max(max_y, y);
        min_y = Math.min(min_y, y);
    }

}