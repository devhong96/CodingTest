import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String[] requirement = br.readLine().toUpperCase(Locale.ROOT).split("");
        int leng = requirement.length;
        String[] voca = new String[leng];

        int freq=0;

        for (int i = 0; i < leng; i++) {
            voca[i] = requirement[i];
            int now_freq = map.getOrDefault(voca[i],0);

            if(now_freq == freq) freq++;
            map.put(voca[i], now_freq + 1);
        }

        List<String> al = new ArrayList<>();

        for (String k: map.keySet()) {
            if(map.get(k) == freq){
                al.add(k);
            }
        }

        if (al.size()>1) {
            System.out.println('?');
        }else{
            System.out.println(al.get(0));
        }
    }
}
