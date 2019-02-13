import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public Runner() {
		// TODO Auto-generated constructor stub
		//pizza
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


		ReadInput reader= new ReadInput();
		File files[] = new File("in").listFiles();
		ArrayList<List<Slice>> results = new ArrayList<>();
		
		int cd =0;
		for(File f : files) {
		
		    
		    Printer.printCutToFile(PizzaCutter.cut2(ReadInput.readFile(f)),"out/"+ cd++ + ".out");;
		  
		}
	
		
		
		



	}

}
