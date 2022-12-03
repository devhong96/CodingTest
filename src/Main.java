import java.util.*;

class Main{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        double sum=0;
        double avg=0;
        double count = 0;

        int[] ints = new int[scan.nextInt()];

        for(int i = 0; i<ints.length;i++) {
            int[] arr = new int[scan.nextInt()];

            for(int j=0; j<arr.length;j++){
                arr[j]=scan.nextInt();
                sum+=arr[j];
            }
            avg= sum/arr.length;


            for (int k=0; k<arr.length; k++) {
                if (avg < arr[k]) {
                    count++;
                }
            }
            System.out.println((count/arr.length)*100);

        }

    }
}

