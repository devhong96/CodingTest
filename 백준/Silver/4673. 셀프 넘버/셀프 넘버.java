import java.util.*;
import java.io.*;

class Main {
    public void solution() {

        boolean[] number = new boolean[10001];

        for (int i = 1; i < 10001; i++) {

            int answer = number(i);

            if (answer < 10001) number[answer] = true;
        }

        for (int j = 1; j < 10001; j++) {
            if (!number[j]) {
                System.out.println(j);
            }
        }
    }

    public static int number(int number) {

        int sum = number;

        while (number != 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args){

        Main T = new Main();
        T.solution();
    }
}
