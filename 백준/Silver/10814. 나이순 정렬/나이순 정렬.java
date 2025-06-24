import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        List<String[]> people = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" "); // [0] = 나이, [1] = 이름
            people.add(input); // 그대로 리스트에 추가
        }

        System.out.println(solution.solution(people));
    }
}

class Person implements Comparable<Person> {

    public Integer age;
    public String name;

    Person (Integer age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }
}

class Solution {
    public String solution(List<String[]> str) {

        ArrayList<Person> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (String[] person : str) {
            list.add(new Person(Integer.parseInt(person[0]), person[1]));
        }

        Collections.sort(list);

        for (Person p : list) {
            sb.append(p.age).append(" ").append(p.name).append('\n');
        }

        return sb.toString().trim();
    }
}
