import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        while (true) {

            int value = br.read();
            if (value == '\n') {
                break;
            }

            if(value<68) answer+=3;
            else if(value < 71) answer += 4;
            else if(value < 74) answer += 5;
            else if(value < 77) answer += 6;
            else if(value < 80) answer += 7;
            else if(value < 84) answer += 8;
            else if(value < 87) answer += 9;
            else answer += 10;
        }
        System.out.println(answer);
    }
}
