import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MagicTrick {
	static ArrayList<int[][]> TotalArray;
	static int FirstAns;
	static int SecondAns;
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("MagicTrick.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("MagicTrick.out");
		String CaseCnt = null;
		TotalArray = null;
		int[][] tmpCard = null;
		
		// read input file
		if(br.ready()) CaseCnt = br.readLine();
		for(int i = 0; i < 5*2*Integer.parseInt(CaseCnt);i++){
			// first row answer
			if(i%10 == 0){
				tmpCard = new int[4][4];
				TotalArray = new ArrayList<int[][]>();
				FirstAns = Integer.parseInt(br.readLine());
			}
			else if(i%5 == 0){
				TotalArray.add(tmpCard);
				tmpCard = new int[4][4];
				SecondAns = Integer.parseInt(br.readLine());
			}
			// output result
			else if(i%10 == 9){
				String[] tokens = br.readLine().split(" ");
				int j = 0;
				for(String t:tokens){
					tmpCard[i%5-1][j] = Integer.parseInt(t);
					j++;
				}
				TotalArray.add(tmpCard);
				
				fw.write("Case #" + ((i/10)+1) + ": ");
				fw.write(Result() + "\r\n");
			}
			else{
				String[] tokens = br.readLine().split(" ");
				int j = 0;
				for(String t:tokens){
					tmpCard[i%5-1][j] = Integer.parseInt(t);
					j++;
				}
			}
		}
		fr.close();
		
		fw.flush();
		fw.close();
	}
	
	public static String Result(){
		int[] Candidate_1 = new int[4];
		int[] Candidate_2 = new int[4];
		int matchCnt = 0;
		String answer = null;
		for(int i=0; i<4;i++){
			Candidate_1[i] = TotalArray.get(0)[FirstAns-1][i];
			//System.out.println("Can_1." + i + ": " + TotalArray.get(0)[FirstAns-1][i]);
			Candidate_2[i] = TotalArray.get(1)[SecondAns-1][i];
			//System.out.println("Can_2." + i + ": " + TotalArray.get(1)[SecondAns-1][i]);
		}
		// check whether match
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				if(Candidate_1[i] == Candidate_2[j]){ 
					matchCnt++;
					answer = String.valueOf(Candidate_1[i]);
				}
		}
		
		if(matchCnt == 1)
			return answer;
		else if(matchCnt == 0)
			return "Volunteer cheated!";
		else
			return "Bad magician!";
	}
}
