import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        
        int score=scan.nextInt();
        String grade="\n";
        
        switch(score/10){
            case 10: grade="A"; break;
            case 9: grade="A"; break;
            case 8: grade="B"; break;
            case 7: grade="C"; break;
            case 6: grade="D"; break;
            
            default: grade="F"; break;
        }
        System.out.print(grade);
    }
}