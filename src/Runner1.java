
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Runner1 {

	public static void main(String[] args) throws IOException {
		
	
		String file="data.txt";
		String str;
		int lineCnt=0;
		int rows=0;
		int cols=0;
		int minNumingredient=0;
		int maxNumCells=0;
		String[][] grid = null;
		ArrayList tempStr = new ArrayList();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		while((str = br.readLine()) != null){
			lineCnt++;
			if(lineCnt==1) {
				String[] words = str.split(" ");
				for (int i = 0; i < words.length; i++) {
					
					if(i==0) {
					rows= Integer.parseInt(words[i]);
					}else if(i==1) {
					cols= Integer.parseInt(words[i]);
					}else if(i==2) {
					minNumingredient= Integer.parseInt(words[i]);
					}else if(i==3){
					maxNumCells= Integer.parseInt(words[i]);
					}else {
						
					}
					
					
				}
				grid = new String [rows+1][cols];
				//System.out.println(rows+" "+cols+" "+minNumingredient+" "+maxNumCells);
			} else
			{
				String[] letters =str.split("");
				for (int i = 0; i < 4; i++) {
					grid[lineCnt-2][i]=letters[i];
					//System.out.print(grid[lineCnt-2][i]);
					
				}
				//System.out.println();
			}
			
		}
		
		//logic
		System.out.println("---------");
		for (int i = 0; i < rows; i++) {
			tempStr.clear();
		  for (int j = 0; j < cols-1; j++) { 
			  tempStr.add(grid[i][0]);
		}
		  //System.out.println();
	}
		//print for test content of arrayList
		for (int i = 0; i < tempStr.size(); i++) {
			//System.out.print(tempStr.get(i));
		}
	}

}
