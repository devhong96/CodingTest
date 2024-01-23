import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        
        int truckIndex = 0, time = 0;
        while(truck_weights.length > truckIndex){
            bridgeWeight -= queue.poll();
            
            int truck = truck_weights[truckIndex];
            if(weight >= truck + bridgeWeight){
                queue.add(truck);
                bridgeWeight += truck;
                truckIndex++;
            } else {
                queue.add(0);
            }
            time++;
        }
        while(bridgeWeight > 0){
            bridgeWeight -= queue.poll();
            time++;
         }
        return time;
    }
}