import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        
        int[] arr = new int[9];
        int max=arr[1];
        int index=1;
        
        for(int i=0;i<arr.length;i++){
            arr[i]=scan.nextInt();
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                index=i+1;
            }
        }
        System.out.println(max);
        System.out.println(index);
	}
}