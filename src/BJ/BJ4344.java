package BJ;

import java.util.*;

class BJ4344 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int AnswerCount = scan.nextInt();

        double[] ans = new double[AnswerCount];//전체 개수

        for(int i = 0; i<AnswerCount;i++) {

            double sum=0;
            double avg=0;
            double count = 0;

            int[] arr = new int[scan.nextInt()];//각각의 점수 개수

            for(int j=0; j<arr.length;j++){
                arr[j]=scan.nextInt();
                sum+=arr[j];
            }

            avg= sum/arr.length;

            for (int j : arr) {
                if (avg < j) {
                    count++;
                }
            }

            ans[i] = (count/arr.length)*100;

        }

        for(int k=0;k<ans.length;k++) {
            System.out.printf("%.3f%%\n", ans[k]);
        }
    }
}

