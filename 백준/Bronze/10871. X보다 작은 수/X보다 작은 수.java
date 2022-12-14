import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        
        int num=scan.nextInt();
        int point=scan.nextInt();
        
        for(int i=0;i<num;i++){
            int number=scan.nextInt();
          if(point>number){
              System.out.print(number+" ");
          }
        }
    }
}