import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        int[] index = new int[count];

        int sum=0;
        int freq = 0;

        for(int i=0; i<count ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            int now_freq = map.getOrDefault(arr[i],0);

            if(now_freq == freq) freq++;
            map.put(arr[i], now_freq+1);
        }

        List<Integer> al = new ArrayList<>();

        for (int k: map.keySet()) {
            if(map.get(k) == freq){
                al.add(k);
            }
        }

        Arrays.sort(arr);
        Collections.sort(al);

        if(al.size()>1){
            freq = al.get(1);
        } else freq = al.get(0);

        long avg = Math.round((double) sum / (int) arr.length);

        System.out.println(avg); //산술평균
        System.out.println(arr[arr.length/2]); // 중앙값
        System.out.println(freq);
        System.out.println(arr[count-1]-arr[0]); //범위

    }
}
