import java.util.*;

class Solution {
    static class Play implements Comparable<Play>{
        public String genre;
        public int index;
        public int value;
        public Play(String genre, int index, int value) {
            this.genre = genre;
            this.index = index;
            this.value = value;
        }
        // 1차적으로는 재생 횟수를 기준으로 내림차순 정렬하고 같을 때는 고유 번호 오름차순
        @Override
        public int compareTo(Play p) {
            if (this.value != p.value) {
                return p.value - this.value;
            }
            return this.index - p.index;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreAndCount = new HashMap<>();
        HashMap<String, ArrayList<Play>> genreAndPlay = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            
            if (genreAndCount.containsKey(genres[i])) {
                genreAndCount.put(genres[i], genreAndCount.get(genres[i]) + plays[i]);
            } else {
                genreAndCount.put(genres[i], plays[i]);
            }
            
            if (genreAndPlay.containsKey(genres[i])) {
                ArrayList<Play> prev = genreAndPlay.get(genres[i]);
                Play newPlay = new Play(genres[i], i, plays[i]);
                prev.add(newPlay);
                genreAndPlay.put(genres[i], prev);
            } else {
                ArrayList<Play> list = new ArrayList<>();
                Play newPlay = new Play(genres[i], i, plays[i]);
                list.add(newPlay);
                genreAndPlay.put(genres[i], list);
            }
        }
        
        String[] genreList = new String[genreAndCount.keySet().size()];
        int pos = 0;
        for (String genre : genreAndCount.keySet()) {
            genreList[pos] = genre;
            pos++;
        }
        
        Arrays.sort(genreList, new Comparator<>() {
           @Override
            public int compare(String s1, String s2) {
                return genreAndCount.get(s2) - genreAndCount.get(s1);
            }
        });
        
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (String genre : genreList) {
            Collections.sort(genreAndPlay.get(genre));
            if (genreAndPlay.get(genre).size() >= 2) {
                resultList.add(genreAndPlay.get(genre).get(0).index);
                resultList.add(genreAndPlay.get(genre).get(1).index);
            } else {
                resultList.add(genreAndPlay.get(genre).get(0).index);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}