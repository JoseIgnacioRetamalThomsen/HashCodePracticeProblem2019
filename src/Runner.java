import java.io.File;
import java.util.List;

public class Runner {

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {


		ReadInput reader= new ReadInput();
		//select file
		Input file1 = reader.readFile(new File("in/a_example.in"));
		file1.printPizza();
		PizzaCutter pc = new PizzaCutter();
		//COMMENT
		List<Slice> l1 = pc.cut1(file1);

	}

}
