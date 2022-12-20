import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        int answer=0;

        for(int i=0; i < count; i++){
            arr[i] = Integer.parseInt(br.readLine());

            for(int k=2; k<=arr[i]; i++){
                if(arr[i]%k==0){
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}