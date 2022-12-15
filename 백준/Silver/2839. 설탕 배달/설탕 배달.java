import java.util.*;

class Main{
    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);

        int sugar = scan.nextInt();
        scan.close();

        if(sugar%5==0){
            System.out.println(sugar/5);
        }else if(sugar==4 || sugar ==7){
            System.out.println(-1);
        }else if(sugar%5==1 || sugar%5==3) {
            System.out.println((sugar/5)+1);
        }else if(sugar%5==2 || sugar%5==4){
            System.out.println((sugar/5)+2);
        }
    }
}