import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] requirement = br.readLine().split(" ");

        int forward = Integer.parseInt(requirement[0]);
        int backward = Integer.parseInt(requirement[1]);
        int length = Integer.parseInt(requirement[2]);

        int day = (length - backward) / (forward - backward);
        if ((length - backward) % (forward - backward) != 0) day++;

        System.out.println(day);

    }
}
