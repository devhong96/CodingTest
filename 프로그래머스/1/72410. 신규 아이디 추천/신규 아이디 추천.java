import java.util.*;

class Solution {
    public String solution(String newId) {
        
        //1 
        String first = newId.toLowerCase();
        
        //2
        String Id = "";
        for(char c : first.toCharArray()){
            if((c >= 'a' && c <= 'z') ||
               (c >= '0' && c <= '9') || 
               c == '-' || c == '.' || c == '_'){
                Id += c;
            }
        }
        System.out.print(Id);
        
        
        //3
        while(Id.contains("..")){
            Id = Id.replace("..", ".");
        }
        
        //4
        if(Id.startsWith(".")) 
            Id = Id.replaceFirst(".","");
        
        if(Id.endsWith("."))
            Id = Id.substring(0, Id.length() - 1);
        
        //5
        if(Id.isEmpty()) Id+="a";
        
        //6
        if(Id.length() > 15)
            Id = Id.substring(0, 15);
        if(Id.endsWith("."))
            Id = Id.substring(0, Id.length() - 1);
        
        //7
        if(Id.length() < 3){
            while(Id.length() < 3){
                Id+=Id.charAt(Id.length() - 1);
            }
        }
        return Id;
    }
}