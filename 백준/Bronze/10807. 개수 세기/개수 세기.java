import java.util.*;

class Main{
    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int arr[] = new int[num];
        int count=0;
        
        for(int i=0;i<num;i++){
            arr[i]=scan.nextInt();
        }
        
        int find=scan.nextInt();
        
        for(int i=0;i<num;i++){
            if(find==arr[i])
                count++;
        }

        System.out.println(count);
        scan.close();
    }
}

