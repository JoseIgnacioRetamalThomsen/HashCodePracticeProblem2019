import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInput {

	public ReadInput() {

	}

	public Input readFile(File file) {
		Input input = new Input();
		int rows = 0;
		int col = 0;
		try {
			Scanner sc = new Scanner(file);
			// read row
			rows = sc.nextInt();
			col = sc.nextInt();

			// read max size
			input.setMinIngredients(sc.nextInt());
			// read max size
			input.setMaxSize(sc.nextInt());
			sc.nextLine();
			//array representing pizza
			int pizza[][] = new int[rows][col];

			for (int i = 0; i < rows; i++) {
				String s = sc.nextLine();
				//System.out.println(s);
				char[] line = s.toCharArray();
				for (int j = 0; j < col; j++) {
					if (line[j] == 'T')
						pizza[i][j] = 0;
					else
						pizza[i][j] = 1;
				}
			}
			input.setPizza(pizza);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
	}

}
