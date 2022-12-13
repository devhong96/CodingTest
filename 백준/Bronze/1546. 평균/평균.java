import java.util.*;

class Main{
    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int arr[] = new int[num];
        double sum=0;
        
        for(int i=0;i<num;i++){
            arr[i]=scan.nextInt();
            sum+=arr[i];
        }
        Arrays.sort(arr);

        int max=arr[arr.length-1];
        double ans = (sum/max)*100/num;
        
        System.out.println(ans);
        scan.close();
    }
}

