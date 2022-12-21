import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] numArr = br.readLine().toCharArray();

        Arrays.sort(numArr);

        for(int i=numArr.length-1; i>=0;i-- ) {
            System.out.print(numArr[i]);
        }

        br.close();
    }
}