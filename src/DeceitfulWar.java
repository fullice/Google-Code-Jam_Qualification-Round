import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class DeceitfulWar {
	static int BlockNum;
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("D-large.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("DeceitfulWar.out");
		String CaseCnt = null;
		ArrayList<Double> ArrayNaomi = null;
		ArrayList<Double> ArrayKen = null;
		ArrayList<Double> ArrayNaomi_2 = null;
		ArrayList<Double> ArrayKen_2 = null;
		
		if(br.ready()) CaseCnt = br.readLine();
		for(int i = 0; i < 3*Integer.parseInt(CaseCnt);i++){
			if(i % 3 == 0){
				BlockNum = Integer.parseInt(br.readLine());
				ArrayNaomi = new ArrayList<Double>();
				ArrayKen = new ArrayList<Double>();
				ArrayNaomi_2 = new ArrayList<Double>();
				ArrayKen_2 = new ArrayList<Double>();
			}
			else if(i % 3 == 1){
				String[] tokens = br.readLine().split(" ");
				for(String t:tokens){
					ArrayNaomi.add(Double.parseDouble(t));
					ArrayNaomi_2.add(Double.parseDouble(t));
				}
			}
			else if(i % 3 == 2){
				String[] tokens = br.readLine().split(" ");
				for(String t:tokens){
					ArrayKen.add(Double.parseDouble(t));
					ArrayKen_2.add(Double.parseDouble(t));
				}
				
				fw.write("Case #" + ((i/3)+1) + ": ");
				fw.write(String.valueOf(DWar(ArrayNaomi, ArrayKen)) + " " + String.valueOf(War(ArrayNaomi_2, ArrayKen_2)) + "\r\n");
			}
		}
		
		System.out.print("finish");
		fr.close();
		
		fw.flush();
		fw.close();
	}
	
	static int DWar(ArrayList<Double> ArrayNaomi, ArrayList<Double> ArrayKen){
		int ans = 0;
		Collections.sort(ArrayNaomi);
		Collections.sort(ArrayKen);
		int BlockNum_Naomi = BlockNum;
		int BlockNum_Ken = BlockNum;
		for(int i=0;i<BlockNum_Naomi;i++){
			for(int j=0;j<BlockNum_Ken;j++){
				if(ArrayNaomi.get(i) > ArrayKen.get(j)){
					ans++;
					ArrayNaomi.remove(j);
					i--;
					BlockNum_Naomi--;
					ArrayKen.remove(j);
					BlockNum_Ken--;
					break;
				}
			}
		}
		return ans;
	}

	static int War(ArrayList<Double> ArrayNaomi, ArrayList<Double> ArrayKen){
		int ans = 0;
		Collections.sort(ArrayNaomi);
		Collections.sort(ArrayKen);
		int BlockNum_Ken = BlockNum;
		for(int i=0;i<BlockNum;i++){
			Double Naomi = ArrayNaomi.get(i);
			for(int j=0;j<BlockNum_Ken;j++){
				if(Naomi < ArrayKen.get(j)){
					ArrayKen.remove(j);
					BlockNum_Ken--;
					break;
				}
			}
		}
		ans = ArrayKen.size();
		return ans;
	}
	
}
