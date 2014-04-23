import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CookieClicker {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("B-large.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("CookieClicker.out");
		String CaseCnt = null;
		double C, F, X;
		
		if(br.ready()) CaseCnt = br.readLine();
		for(int i = 0; i < Integer.parseInt(CaseCnt);i++){
			String[] tokens = br.readLine().split(" ");
			C = Double.parseDouble(tokens[0]);
			F = Double.parseDouble(tokens[1]);
			X = Double.parseDouble(tokens[2]);
			
			fw.write("Case #" + (i+1) + ": ");
			fw.write(String.valueOf(Calc(C, F, X)) + "\r\n");
		}
		
		//System.out.println(String.valueOf(Calc(500, 4, 2000)));
		System.out.print("finish");
		fr.close();
		
		fw.flush();
		fw.close();
	}
	
	public static double Calc(double C, double F, double X){
		double gold = 0;
		double ans = 0;
		boolean getGoal = false;
		double rate = 2;
		
		//System.out.println("C: " + C + ", F: " + F + ", X: " + X);
		
		while(!getGoal){
			if(X/rate > (C/rate + X/(rate+F))){
				ans += C/rate;
				rate += F;
				//System.out.println("ans = " + ans);
			}
			else{
				ans += X/rate;
				getGoal = true;
			}
				
		}
		
		return ans;
	}
}
