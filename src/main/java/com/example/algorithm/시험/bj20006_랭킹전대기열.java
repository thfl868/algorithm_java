package com.example.algorithm.시험;
import java.io.*;
import java.util.*;
public class bj20006_랭킹전대기열 {
    /**
     * 플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 생성하고 입장시킨다.
     * 이떄 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능하다.
     * 입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기시킨다.
     * 이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.
     * 방의 정원이 모두 차면 게임을 시작시킨다.*/
    static List<List<Player>> room_list = new ArrayList<>();//플레이어가 들어가있는 방 리스트
    static List<int[]> room_info = new ArrayList<>(); // 방의 레벨과 정원을 입력하는 리스트
    static int p,m ;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
         p = Integer.parseInt(str[0]); //플레이어수
         m = Integer.parseInt(str[1]); //한 방의 정원

        for(int i=0; i<p; i++){

            String[] player = br.readLine().split(" ");
            int l = Integer.parseInt(player[0]);
            String n = player[1];
            //방 매칭
            match_room(new Player(l, n));

        }

        StringBuilder sb = new StringBuilder();
        //만들어진 방 출력하기
        for(int i=0; i<room_list.size(); i++){
            if(room_info.get(i)[1] == m){ //방의 정원이 다 찼으면 Started! 출력
                sb.append("Started!\n");
            }else{ //Waiting! 출력
                sb.append("Waiting!\n");
            }
            //방에있는사람 레벨, 이름 출력
            List<Player> room = room_list.get(i);
            //닉네임 차순으로 정렬
            room.sort(Comparator.comparing(o -> o.n)); //todo String 정렬하는 방법 정리
            for(Player p : room){
                sb.append(p.l + " "+p.n+"\n");
            }
        }
        System.out.print(sb);
    }

    private static void match_room(Player player) {
        //없으면 새로운 방 생성하고 입장 시키기
        if(room_info.isEmpty()){ // 처음 들어왔을때
            int[] info = {player.l , 1};
            room_info.add(info);
            List list = new ArrayList<Player>();
            list.add(player);
            room_list.add(list);
            return;
        }
        //매칭 가능한 방 있는지 찾고 있으면 입장시키기
        for(int i=0;i<room_info.size();i++){
            int level = room_info.get(i)[0];
            int cnt = room_info.get(i)[1];
            if(cnt >= m) continue; //정원 이상이면 넘어가기

            if(player.l >= level-10 && player.l <= level+10){
                //플레이어 레벨이 입장 가능인지 확인하고 넣기
                room_info.get(i)[1] = cnt+1; //정원 한명 추가
                room_list.get(i).add(player); //해당 방에 플레이어 추가
                return;
            }
        }

        //매칭 가능한 방 없으면 방 생성하고 입장.
        int[] info = {player.l , 1};
        room_info.add(info);
        List list = new ArrayList<Player>();
        list.add(player);
        room_list.add(list);
        return;


    }

    public static class Player {
        int l; //레벨
        String n; //닉네임

        public Player(int l, String n){
            this.l = l;
            this.n = n;
        }


    }
}
