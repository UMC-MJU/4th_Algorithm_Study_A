package BOJ.week24_5;

import java.util.*;
import java.io.*;
public class 호텔대실 {
    static class Time{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String[][] book_time) {
        List<Time> bookList = new ArrayList<>();
        for(String[] bookTime : book_time){
            String startStr = bookTime[0];
            String[] startArr = startStr.split(":");
            int start = (Integer.parseInt(startArr[0]) * 60) + Integer.parseInt(startArr[1]);
            String endStr = bookTime[1];
            String[] endArr = endStr.split(":");
            int end = (Integer.parseInt(endArr[0]) * 60) + Integer.parseInt(endArr[1]);
            bookList.add(new Time(start, end));
        }
        Collections.sort(bookList, ((o1, o2) -> o1.start - o2.start)); // 시작시간으로 오름차순 정렬
        List<Time> resultList = new ArrayList<>();
        resultList.add(bookList.get(0));
        for(int i = 1; i < bookList.size(); i++){
            boolean isPossible = false;
            for(int j = 0; j < resultList.size(); j++){
                if(bookList.get(i).start >= resultList.get(j).end + 10){
                    resultList.remove(j);
                    resultList.add(bookList.get(i));
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible){ // 아직 배정받지 못했으면
                resultList.add(bookList.get(i));
            }
        }
        return resultList.size();
    }
}
