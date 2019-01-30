
public class Input {

	int maxSize;
	int minIngredients;
	int[][] pizza;
	
	public Input() {
		// TODO Auto-generated constructor stub
	}

	public Input(int maxSize, int minIngredients, int[][] pizza) {
		super();
		this.maxSize = maxSize;
		this.minIngredients = minIngredients;
		this.pizza = pizza;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getMinIngredients() {
		return minIngredients;
	}

	public void setMinIngredients(int minIngredients) {
		this.minIngredients = minIngredients;
	}

	public int[][] getPizza() {
		return pizza;
	}

	public void setPizza(int[][] pizza) {
		this.pizza = pizza;
	}
	public void printPizza()
	{
		for(int i = 0; i<this.pizza.length; i++)
		{
		    for(int j = 0; j<this.pizza[0].length; j++)
		    {
		        System.out.print(this.pizza[i][j]);
		    }
		    System.out.println();
		}
	}
	public int getHeightOfPizza()
	{
		return this.pizza.length;
	}
	public int getLengthofPizza()
	{
		return this.pizza[0].length;
	}

}
