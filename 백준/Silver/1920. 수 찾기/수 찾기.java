import java.io.*;
import java.util.*;

public class Main {
	static int N = 0;
	static int[] a;
	
	static boolean bs(int k) {
		
	    // l, r, m은 index 일뿐 실제 값을 a에서 찾아 비교해야 한다.
		int l = 0;
		int r = N - 1;
		
		if (a[l] > k || a[r] < k) {
			return false;
		}
		
		while (l <= r) {
	        int m = (l + r) / 2;
	        
	        if (a[m] == k)
	        {
	            return true;
	        }
	        else if (a[m] > k)
	        {
	            r = m - 1;
	        }
	        else
	        {
	            l = m + 1;
	        }
		}
		
		return false;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int M = Integer.parseInt(br.readLine());
		int[] b = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			if (bs(b[i])) {
				System.out.println("1");
			} else {
				System.out.println("0");				
			}
		}
	}
}