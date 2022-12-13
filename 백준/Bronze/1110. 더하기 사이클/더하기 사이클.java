import java.util.*;

class Main{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        int num=scan.nextInt();
        scan.close();

        int i=0;
        int ans=num;


        if(num<10){

            ans=num*10;
            ans=ans%10+ans/10;
        }

        do{
            ans = (ans/10 + ans%10)%10 + ans%10*10;
            i++;

        }while(num!=ans);

        System.out.print(i);


    }
}

