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
        List<int[][]> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[][] data = new int[num][2];

            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                data[j][0] = Integer.parseInt(st.nextToken());
                data[j][1] = Integer.parseInt(st.nextToken());

            }
            list.add(data);

        }

        System.out.print(solution.solution(list));
    }
}

class Person implements Comparable<Person> {
    int document;
    int interview;

    public Person(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }

    @Override
    public int compareTo(Person p) {
        if(this.document == p.document) return this.interview - p.interview;
        else return this.document - p.document;
    }
}

class Solution {
    public String solution(List<int[][]> a) {

        StringBuilder sb = new StringBuilder();

        for (int[][] ints : a) {
            int min = Integer.MAX_VALUE, count = 0;
            ArrayList<Person> list = new ArrayList<>();
            for (int[] anInt : ints) {
                list.add(new Person(anInt[0], anInt[1]));
            }
            Collections.sort(list);

            for (Person person : list) {
                int interview = person.interview;
                if (interview < min) {
                    count++;
                    min = interview;
                }
            }

            sb.append(count).append("\n");
        }
        
        return sb.toString();
    }
}
