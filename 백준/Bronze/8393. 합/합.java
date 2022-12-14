import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        
        int sum=0;
        int num=scan.nextInt();
        
        for(int i=1;i<=num;i++){
            sum+=i;      
        }
        System.out.println(sum);
    }
}