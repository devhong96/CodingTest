import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int[][] point = new int[count][2];

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());

        }

        System.out.println(solution.solution(point));
    }
}

class Point implements Comparable<Point> {

    public int x;
    public int y;

    Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}

class Solution {
    public String solution(int[][] point) {


        ArrayList<Point> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int[] p : point) {
            list.add(new Point(p[0], p[1]));
        }

        Collections.sort(list);

        for (Point p : list) {
            sb.append(p.x).append(" ").append(p.y).append('\n');
        }

        return sb.toString().trim();
    }
}
