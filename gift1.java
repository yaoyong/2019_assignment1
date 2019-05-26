import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class gift1 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("gift1.in"));
		final int NP = Integer.valueOf(in.nextLine());
		
		String[] names = new String[NP];
		HashMap<String, Integer> givers = new HashMap<String, Integer>();
		
		for(int i=0; i<NP; i++) {
			names[i] = in.nextLine();
			givers.put(names[i], 0);
		}
		
		for(int i=0; i<NP; i++) {
			String giver = in.nextLine();
			StringTokenizer st = new StringTokenizer(in.nextLine());
			int giftTotal = Integer.valueOf(st.nextToken());
			int giftCount = Integer.valueOf(st.nextToken());
			
			int giftAmt = (giftCount > 0) ? giftTotal / giftCount : 0;
			int netLoss = giftCount * giftAmt;
			int currentCash = givers.get(giver);
			givers.put(giver, currentCash-netLoss);
			
			for(int j=0; j<giftCount; j++) {
				String giftee = in.nextLine();
				currentCash = givers.get(giftee);
				givers.put(giftee, currentCash+giftAmt);
			}
		}
		in.close();
		
		PrintWriter out = new PrintWriter(new File("gift1.out"));
		for(int i=0; i<NP; i++) {
			out.println(names[i] + ' ' + givers.get(names[i]));
		}
		out.close(); System.exit(0);
	}
}
