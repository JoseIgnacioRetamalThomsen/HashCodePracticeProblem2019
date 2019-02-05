import java.io.File;
import java.util.List;

public class Runner {

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {


		ReadInput reader= new ReadInput();
		//select file
		//Input file1 = reader.readFile(new File("in/a_example.in"));
		
		Input file1 = reader.readFile(new File("in/b_small.in"));
		//Input file1 = reader.readFile(new File("in/c_medium.in"));
		file1.printPizza();
		PizzaCutter pc = new PizzaCutter();
		//COMMENT
		List<Slice> l1 = pc.cut1(file1);
		pc.cut2(file1);

	}

}
