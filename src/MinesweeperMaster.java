import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Not Resolve!
 */

public class MinesweeperMaster {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("MinesweeperMaster.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("MinesweeperMaster.out");
		String CaseCnt = null;
		int R, C, Cnt;
		
		if(br.ready()) CaseCnt = br.readLine();
		for(int i = 0; i < Integer.parseInt(CaseCnt);i++){
			String[] tokens = br.readLine().split(" ");
			R = Integer.parseInt(tokens[0]);
			C = Integer.parseInt(tokens[1]);
			Cnt = Integer.parseInt(tokens[2]);
			
			fw.write("Case #" + (i+1) + ":\r\n");
			fw.write(Calc(R, C, Cnt));
		}
		
		System.out.print("finish");
		fr.close();
		
		fw.flush();
		fw.close();
	}
	
	static String Calc(int R, int C, int Cnt){
		String ans = "";
		int CurrentCnt = 0;
		if(R == 1 || C == 1){
			if(R*C - Cnt >= 1){
				for(int i=0; i<R;i++){
					for(int j=0;j<C;j++){
						if(CurrentCnt == 0)
							ans += "c ";
						else if(R*C - Cnt > CurrentCnt)
							ans += ". ";
						else
							ans += "* ";
						CurrentCnt++;
					}
					ans += "\r\n";
				}
			}
			else
				return "Impossible\r\n";
		}
		else{
			if(R*C - Cnt == 1){
				for(int i=0; i<R;i++){
					for(int j=0;j<C;j++){
						if(CurrentCnt == 0)
							ans += "c ";
						else
							ans += "* ";
						CurrentCnt++;
					}
					ans += "\r\n";
				}
			}
			else if(R*C - Cnt >= 4){
				int mineCnt = Cnt;
				if(mineCnt <= (R-1)*(C-1)){
					
				}
				
				
			}
			else 
				return "Impossible\r\n";
		}
		return ans;
	}
}
