import java.util.*;

class Main{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        int[] arr = new int[10];
        int count=0;

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0; i<arr.length;i++) {

            int num = scan.nextInt();
            hashSet.add(num % 42);
        }

        System.out.println(hashSet.size());
        scan.close();
    }
}

