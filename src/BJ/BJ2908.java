package BJ;

import java.util.*;

class BJ2908 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();

        A= Integer.parseInt(new StringBuilder().append(A).reverse().toString());
        B= Integer.parseInt(new StringBuilder().append(B).reverse().toString());

        System.out.print(A > B ? A : B);


    }
}

