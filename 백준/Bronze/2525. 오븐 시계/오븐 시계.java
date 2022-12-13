import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        
        int hour=scan.nextInt();//시간
        int minutes=scan.nextInt();//분
        
        int time=scan.nextInt();//넣을 값
        
        int A = hour*60 + minutes + time;
        if(A>=60*24){
            System.out.println((A-(60*24))/60+" "+A%60);
        }else{
             System.out.println(A/60+" "+A%60);
        }    
    }
}