import java.util.HashMap;
import java.util.ArrayList;

class 방문_길이 {

    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static HashMap<String, Integer> command;
    private static int count;

    public int solution(String dirs) {
        count = 0;
        command = new HashMap<>();
        command.put("U", 0);
        command.put("D", 1);
        command.put("L", 2);
        command.put("R", 3);

        String[] commands = dirs.split("");
        ArrayList<String> routes = new ArrayList<>();

        int y = 0;
        int x = 0;

        for (String c : commands) {
            int ny = y + dy[command.get(c)];
            int nx = x + dx[command.get(c)];

            if (ny > 5 || nx > 5 || ny < -5 || nx < -5) {
                continue;
            }

            String route = y + "," + x + " - " + ny + "," + nx;
            String reversed = ny + "," + nx + " - " + y + "," + x;
            y = ny;
            x = nx;
            if (routes.contains(route) || routes.contains(reversed)) {
                continue;
            }

            count++;
            // System.out.println(route + " " + c);
            routes.add(route);
        }

        return count;
    }
}
