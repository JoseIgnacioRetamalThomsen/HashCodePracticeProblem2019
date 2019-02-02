import java.io.File;
import java.util.List;

public class Runner {

	public Runner() {
		// TODO Auto-generated constructor stub
		//pizza
	}

	public static void main(String[] args) {


		ReadInput reader= new ReadInput();
		Input file1 = reader.readFile(new File("in/a_example.in"));

		PizzaCutter pc = new PizzaCutter();
		List<Slice> l1 = pc.cut1(file1);


	}

}
