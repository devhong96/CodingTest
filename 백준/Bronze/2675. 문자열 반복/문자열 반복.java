import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++){

            String[] str = br.readLine().split(" ");
            int countTime = Integer.parseInt(str[0]);
            String S = str[1];

            for(int j=0; j<S.length();j++){
                for(int k=0; k<countTime; k++){
                    sb.append(S.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}