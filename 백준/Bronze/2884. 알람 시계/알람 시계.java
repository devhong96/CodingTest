import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        
        int hour=0,minutes=0;
        
        int h=scan.nextInt();
        int m=scan.nextInt();
        
        if(m<45){     
            if(h>0){
                hour=h-1; minutes=15+m; 
                System.out.print(hour+" "+minutes);
            }else if(h<=0){
                hour=23; minutes=15+m;     
                System.out.print(hour+" "+minutes);
            }
        }else if(m>=45){
            hour=h; minutes=m-45;
            System.out.print(hour+" "+minutes);
        }    
        }
 }