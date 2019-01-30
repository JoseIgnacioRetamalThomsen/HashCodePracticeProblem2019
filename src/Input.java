
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

	
}
