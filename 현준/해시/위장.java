import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            if (map.containsKey(type)) {
                ArrayList<String> prev = map.get(type);
                prev.add(name);
                map.put(type, prev);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(name);
                map.put(type, newList);
            }
        }
        int multiple = 1;
        for (String key : map.keySet()) {
            multiple *= (map.get(key).size() + 1);
        }
        return multiple - 1;
    }
}