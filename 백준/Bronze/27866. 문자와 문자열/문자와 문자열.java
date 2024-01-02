import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int num = scanner.nextInt();
      
        char answer = word.charAt(num - 1);
        System.out.print(answer);
    }
}