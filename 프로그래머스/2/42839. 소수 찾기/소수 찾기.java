import java.util.*;
import java.util.stream.Collectors;

class Solution{
    public int solution(String numbers){

        Set<Integer> primes = new HashSet<>();

        List<Integer> number = numbers.chars()
            .map(c -> c - '0').boxed()
            .collect(Collectors.toList());

        getPrimes(0, number, primes);

        return primes.size();
    }

    private void getPrimes(int num, List<Integer> number, Set<Integer> primes){
        if(isPrime(num)) primes.add(num);
        for (int i = 0; i < number.size(); i++) {
            int nextNum = num * 10 + number.get(i);
            List<Integer> nextNumbers = new ArrayList<>(number);
            nextNumbers.remove(i);
            getPrimes(nextNum, nextNumbers, primes);
        }
    }

    private boolean isPrime(int n){
        if(n<=1) return false;

        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}

