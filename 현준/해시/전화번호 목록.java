import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        ArrayList<String> list = new ArrayList<>();
        list.add(phone_book[0]);
        for (int i = 1; i < phone_book.length; i++) {
            if (list.get(list.size() - 1).startsWith(phone_book[i]) || phone_book[i].startsWith(list.get(list.size() - 1))) {
                return false;
            }
            list.add(phone_book[i]);
        }
        return true;
    }
}