import java.util.*;

class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int sum=0;
        int count = scan.nextInt();
        String num = scan.next();


        for(int i=0;i<count;i++){
            sum+=num.charAt(i)-48;
        }
        System.out.println(sum);
    }
}

