import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = br.readLine().trim();

        if(answer.isEmpty()){
           System.out.println('0');
        }else {
            System.out.println(answer.split(" ").length);
        }
    }
}