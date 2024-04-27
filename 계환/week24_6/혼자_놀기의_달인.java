package BOJ.week24_6;

import java.io.*;
import java.util.*;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        int answer = 1;
        PriorityQueue<Integer> pointList = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] isOpen = new boolean[cards.length+1];
        isOpen[0] = true;
        int nextBox = 0;
        int openCount = 0;
        while(openCount != cards.length){
            int point = 0;
            for(int i = 0; i < cards.length; i++){
                if(!isOpen[i]){
                    nextBox = i;
                    break;
                }
            }
            while(true){
                point++;
                openCount++;
                isOpen[nextBox] = true;
                nextBox = cards[nextBox-1];
                if(isOpen[nextBox]){
                    if(point>0){
                        pointList.add(point);
                        break;
                    }
                }
            }
        }
        if (pointList.size() >= 2) {
            answer *= pointList.poll();
            answer *= pointList.poll();
        } else {
            answer = 0;
        }
        return answer;
    }
}
